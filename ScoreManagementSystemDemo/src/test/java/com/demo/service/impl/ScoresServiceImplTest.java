package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.domain.bo.Scores;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.dto.StudentScoresListDto;
import com.demo.domain.mapper.ScoresMapper;
import com.demo.domain.vo.ScoreInfoVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScoresServiceImplTest {

    @Mock
    private ScoresMapper mockScoresMapper;

    @InjectMocks
    private ScoresServiceImpl scoresServiceImplUnderTest;

    /**
     *
     */
    @Test
    void testGetScoresList() {
        // Setup
        final StudentScoresListDto studentListDto = new StudentScoresListDto();
        studentListDto.setName("lewis");
        studentListDto.setType("1");
        studentListDto.setClasses("1");

        final ScoreInfoVo scoreInfoVo = new ScoreInfoVo();
        scoreInfoVo.setId("1");
        scoreInfoVo.setSubject("maths");
        scoreInfoVo.setScore(99);
        scoreInfoVo.setType("1");
        scoreInfoVo.setStuNo("001");
        final List<ScoreInfoVo> expectedResult = List.of(scoreInfoVo);

        // Configure ScoresMapper.findScoreInfoList(...).
        final ScoreInfoVo scoreInfoVo1 = new ScoreInfoVo();
        scoreInfoVo1.setId("1");
        scoreInfoVo1.setSubject("maths");
        scoreInfoVo1.setScore(99);
        scoreInfoVo1.setType("1");
        scoreInfoVo1.setStuNo("001");

        final List<ScoreInfoVo> scoreInfoVos = List.of(scoreInfoVo1);
        when(mockScoresMapper.findScoreInfoList("1","1","lewis")).thenReturn(scoreInfoVos);

        // Run the test
        final List<ScoreInfoVo> result = scoresServiceImplUnderTest.getScoresList(studentListDto);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetScoresList_ScoresMapperReturnsNoItems() {
        // Setup
        final StudentScoresListDto studentListDto = new StudentScoresListDto();
        studentListDto.setName("");
        studentListDto.setType("");
        studentListDto.setClasses("1");

        when(mockScoresMapper.findScoreInfoList("", "1", "")).thenReturn(Collections.emptyList());

        // Run the test
        final List<ScoreInfoVo> result = scoresServiceImplUnderTest.getScoresList(studentListDto);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetStudentScoresInfo() {
        // Setup
        final Scores expectedResult = new Scores();
        expectedResult.setId("1");
        expectedResult.setSubject("chinese");
        expectedResult.setScore(80);
        expectedResult.setType("1");
        expectedResult.setStuNo("001");

        // Configure ScoresMapper.selectOne(...).
        final Scores scores = new Scores();
        scores.setId("1");
        scores.setSubject("chinese");
        scores.setScore(80);
        scores.setType("1");
        scores.setStuNo("001");
        when(mockScoresMapper.selectOne(any(LambdaQueryWrapper.class))).thenReturn(scores);

        // Run the test
        final Scores result = scoresServiceImplUnderTest.getStudentScoresInfo("1");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testInsertStudentScores() {
        // Setup
        final Scores scores = new Scores();
        scores.setId("1");
        scores.setSubject("chinese");
        scores.setScore(90);
        scores.setType("1");
        scores.setStuNo("1");

        // Configure ScoresMapper.insert(...).
        when(mockScoresMapper.insert(scores)).thenReturn(1);

        // Run the test
        final String result = scoresServiceImplUnderTest.insertStudentScores(scores);

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testUpdateStudentScores() {
        // Setup
        final Scores scores = new Scores();
        scores.setId("1");
        scores.setSubject("1");
        scores.setScore(89);
        scores.setType("1");
        scores.setStuNo("001");

        // Configure ScoresMapper.updateById(...).
        final Scores entity = new Scores();
        entity.setId("1");
        entity.setSubject("1");
        entity.setScore(89);
        entity.setType("1");
        entity.setStuNo("001");
        when(mockScoresMapper.updateById(entity)).thenReturn(1);

        // Run the test
        final String result = scoresServiceImplUnderTest.updateStudentScores(scores);

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testDeleteStudentScores() {
        // Setup
        when(mockScoresMapper.deleteById("1")).thenReturn(1);

        // Run the test
        final String result = scoresServiceImplUnderTest.deleteStudentScores("1");

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testGetAvgScoreInfor() {
        // Setup
        final ScoreInfoDto scoreInfoDto = new ScoreInfoDto();
        scoreInfoDto.setSubject("1");
        scoreInfoDto.setClasses("1");
        scoreInfoDto.setType("1");


        final Map<String, Double> expectedResult = Map.ofEntries(Map.entry("average", 99.0));

        // Configure ScoresMapper.findAvgScoreInforlist(...).
        final ScoreInfoVo scoreInfoVo = new ScoreInfoVo();
        scoreInfoVo.setId("1");
        scoreInfoVo.setSubject("1");
        scoreInfoVo.setScore(99);
        scoreInfoVo.setType("1");
        scoreInfoVo.setStuNo("001");
        final List<ScoreInfoVo> scoreInfoVos = List.of(scoreInfoVo);
        when(mockScoresMapper.findAvgScoreInforlist("1", "1", "1")).thenReturn(scoreInfoVos);

        // Run the test
        final Map result = scoresServiceImplUnderTest.getAvgScoreInfor(scoreInfoDto);
        // Verify the results
        assertThat(result.get("average")).isEqualTo(expectedResult.get("average"));
    }

    @Test
    void testGetAvgScoreInfor_ScoresMapperReturnsNoItems() {
        // Setup
        final ScoreInfoDto scoreInfoDto = new ScoreInfoDto();
        scoreInfoDto.setSubject("");
        scoreInfoDto.setClasses("");
        scoreInfoDto.setType("");

        final Map<String, String> expectedResult = Map.ofEntries(Map.entry("value", "value"));
        when(mockScoresMapper.findAvgScoreInforlist("", "", "")).thenReturn(Collections.emptyList());

        // Run the test
        final Map<String, String> result = scoresServiceImplUnderTest.getAvgScoreInfor(scoreInfoDto);

        // Verify the results
        assertThat(result.get("classes")).isEmpty();
    }

    @Test
    void testGetSum() {
        assertThat(scoresServiceImplUnderTest.getSum(new Integer[]{0})).isEqualTo(0);
    }

    @Test
    void testGetAvg() {
        assertThat(scoresServiceImplUnderTest.getAvg(new Integer[]{0})).isEqualTo(0.0, within(0.0001));
    }
}

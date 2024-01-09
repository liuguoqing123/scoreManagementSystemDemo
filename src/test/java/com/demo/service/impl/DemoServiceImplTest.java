package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.domain.bo.Score;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.dto.StudentListDto;
import com.demo.domain.mapper.StudentMapper;
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
class DemoServiceImplTest {

    @Mock
    private StudentMapper mockStudentMapper;

    @InjectMocks
    private DemoServiceImpl demoServiceImplUnderTest;

    @Test
    void testGetStudentList() {
        // Setup
        final StudentListDto studentListDto = new StudentListDto();
        studentListDto.setName("name");
        studentListDto.setType("1");
        studentListDto.setClasses("1");

        final Score score = new Score();
        score.setId("1");
        score.setName("name");
        score.setScore("88");
        score.setType("1");
        score.setSubject("maths");
        score.setClasses("1");
        final List<Score> expectedResult = List.of(score);

        // Configure StudentMapper.selectList(...).
        final Score score1 = new Score();
        score1.setId("1");
        score1.setName("name");
        score1.setScore("99");
        score1.setType("1");
        score1.setSubject("maths");
        score1.setClasses("1");
        final List<Score> scores = List.of(score1);
        when(mockStudentMapper.selectList(any(LambdaQueryWrapper.class))).thenReturn(scores);

        // Run the test
        final List<Score> result = demoServiceImplUnderTest.getStudentList(studentListDto);

        // Verify the results
        assertThat(result).isNotEmpty();
    }

    @Test
    void testGetStudentList_StudentMapperReturnsNoItems() {
        // Setup
        final StudentListDto studentListDto = new StudentListDto();
        studentListDto.setName("name");
        studentListDto.setType("1");
        studentListDto.setClasses("1");

        when(mockStudentMapper.selectList(any(LambdaQueryWrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<Score> result = demoServiceImplUnderTest.getStudentList(studentListDto);

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testInsertStudent() {
        // Setup
        final Score score = new Score();
        score.setId("1");
        score.setName("name");
        score.setScore("66");
        score.setType("1");
        score.setSubject("maths");
        score.setClasses("1");

        // Configure StudentMapper.insert(...).
        final Score entity = new Score();
        entity.setId("1");
        entity.setName("name");
        entity.setScore("77");
        entity.setType("1");
        entity.setSubject("1");
        entity.setClasses("1");
        when(mockStudentMapper.insert(any())).thenReturn(1);

        // Run the test
        final String result = demoServiceImplUnderTest.insertStudent(score);

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testUpdateStudent() {
        // Setup
        final Score score = new Score();
        score.setId("1");
        score.setName("name");
        score.setScore("66");
        score.setType("1");
        score.setSubject("maths");
        score.setClasses("1");

        // Configure StudentMapper.updateById(...).
        final Score entity = new Score();
        entity.setId("1");
        entity.setName("name");
        entity.setScore("98");
        entity.setType("q");
        entity.setSubject("maths");
        entity.setClasses("1");
        when(mockStudentMapper.updateById(any())).thenReturn(1);

        // Run the test
        final String result = demoServiceImplUnderTest.updateStudent(score);

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testDeleteStudent() {
        // Setup
        when(mockStudentMapper.deleteById("1")).thenReturn(1);

        // Run the test
        final String result = demoServiceImplUnderTest.deleteStudent("1");

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testGetScoreInfor() {
        // Setup
        final ScoreInfoDto scoreInfoDto = new ScoreInfoDto();
        scoreInfoDto.setSubject("subject");
        scoreInfoDto.setClasses("classes");
        scoreInfoDto.setType("type");

        final Map<String, String> expectedResult = Map.ofEntries(Map.entry("value", "value"));

        // Configure StudentMapper.selectList(...).
        final Score score = new Score();
        score.setId("1");
        score.setName("name");
        score.setScore("65");
        score.setType("1");
        score.setSubject("maths");
        score.setClasses("1");
        final List<Score> scores = List.of(score);
        when(mockStudentMapper.selectList(any(LambdaQueryWrapper.class))).thenReturn(scores);

        // Run the test
        final Map<String, String> result = demoServiceImplUnderTest.getScoreInfor(scoreInfoDto);

        // Verify the results
        assertThat(result).isNotEmpty();
    }

    @Test
    void testGetScoreInfor_StudentMapperReturnsNoItems() {
        // Setup
        final ScoreInfoDto scoreInfoDto = new ScoreInfoDto();
        scoreInfoDto.setSubject("maths");
        scoreInfoDto.setClasses("1");
        scoreInfoDto.setType("1");

        final Map<String, String> expectedResult = Map.ofEntries(Map.entry("value", "value"));
        when(mockStudentMapper.selectList(any(LambdaQueryWrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final Map<String, String> result = demoServiceImplUnderTest.getScoreInfor(scoreInfoDto);

        // Verify the results
        assertThat(result).isNotEmpty();
    }

    @Test
    void testGetSum() {
        assertThat(demoServiceImplUnderTest.getSum(new int[]{0})).isEqualTo(0);
    }

    @Test
    void testGetAvg() {
        assertThat(demoServiceImplUnderTest.getAvg(new int[]{0})).isEqualTo(0.0, within(0.0001));
    }
}

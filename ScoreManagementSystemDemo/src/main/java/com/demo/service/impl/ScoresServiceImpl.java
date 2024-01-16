package com.demo.service.impl;


import com.demo.domain.bo.Scores;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.vo.ScoreInfoVo;
import com.demo.domain.dto.StudentScoresListDto;
import com.demo.service.ScoresService;

import com.demo.domain.mapper.ScoresMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Lewis Liu
 */
@Service
@Slf4j
public class ScoresServiceImpl implements ScoresService {

    @Autowired
    private ScoresMapper scoresMapper;

    @Override
    public List<ScoreInfoVo> getScoresList(StudentScoresListDto studentListDto) {
        log.info("getScoresList start, request: " + studentListDto);

        List<ScoreInfoVo> scoresList = scoresMapper.findScoreInfoList(studentListDto.getType(),studentListDto.getClasses(),studentListDto.getName());

        log.info("getScoresList end");
        return scoresList;
    }

    @Override
    public Scores getStudentScoresInfo(String  id) {
        log.info("getStudentInfo start, request: " + id);
        LambdaQueryWrapper<Scores> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Scores::getId,id);
        Scores scores = scoresMapper.selectOne(queryWrapper);
        log.info("getStudentInfo end, result:" + scores);
        return scores;
    }

    @Override
    public String insertStudentScores(Scores scores) {
        log.info("insertStudent start, request: " + scores);
        scores.setId(null);
        int i = scoresMapper.insert(scores);
        log.info("insertStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public String updateStudentScores(Scores scores) {
        log.info("updateStudent start, request: " + scores);
        int i = scoresMapper.updateById(scores);
        log.info("updateStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public String deleteStudentScores(String id) {
        log.info("deleteStudent start, request: " + id);
        int i = scoresMapper.deleteById(id);
        log.info("deleteStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public Map getAvgScoreInfor(ScoreInfoDto scoreInfoDto) {
        log.info("getScoreInfor start, request: " + scoreInfoDto);

        Map resultMap = new HashMap<>();

        List<ScoreInfoVo> studentList = scoresMapper.findAvgScoreInforlist(scoreInfoDto.getType(),scoreInfoDto.getClasses(),scoreInfoDto.getSubject());

        List<Integer> scoreList = studentList.stream().map(ScoreInfoVo::getScore).collect(Collectors.toList());
        if(scoreList.isEmpty()){
            resultMap.put("classes", scoreInfoDto.getClasses());
            resultMap.put("type", scoreInfoDto.getType());
            return resultMap;
        }
        Integer[] scoreInt = scoreList.toArray(new Integer[0]);
        //int[] scoreInt = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();

        //获取平均数方法1
        /*        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        double average1 = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);*/
        //获取平均数方法2
        double average2 = getAvg(scoreInt);
        average2 = Math.round(average2 * 100.0) / 100.0;
        double median = calculateMedian(scoreInt);
        median = Math.round(median * 100.0) / 100.0;

        resultMap.put("classes", scoreInfoDto.getClasses());
        resultMap.put("type", scoreInfoDto.getType());
        resultMap.put("average", average2);
        resultMap.put("median", median);
        log.info("deleteStudent end, average2: " + average2 + ",median: " + median);
        return resultMap;
    }

    public int getSum(Integer[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public double getAvg(Integer[] arr) {
        double average = (double) getSum(arr) / arr.length;
        return average;
    }

    private double calculateMedian(Integer[] array) {
        Arrays.sort(array); //对数字进行排序
        int length = array.length;
        if (length % 2 == 0) {//2的倍数
            return ((double) array[length / 2 - 1] + array[length / 2]) / 2;
        } else {
            return array[length / 2];
        }
    }

}

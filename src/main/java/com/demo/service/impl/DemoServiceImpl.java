package com.demo.service.impl;


import com.demo.domain.bo.Score;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.dto.StudentListDto;
import com.demo.service.DemoService;

import com.demo.domain.mapper.StudentMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Lewis Liu
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Score> getStudentList(StudentListDto studentListDto) {
        log.info("getStudentList start, request: " + studentListDto);
        LambdaQueryWrapper<Score> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(studentListDto.getType())) {
            queryWrapper.eq(Score::getType, studentListDto.getType());
        }
        if (StringUtils.isNotBlank(studentListDto.getClasses())) {
            queryWrapper.eq(Score::getClasses, studentListDto.getClasses());
        }
        if (StringUtils.isNotBlank(studentListDto.getName())) {
            queryWrapper.eq(Score::getName, studentListDto.getName());
        }

        List<Score> studentList = studentMapper.selectList(queryWrapper);
        log.info("getStudentList end");
        return studentList;
    }

    @Override
    public String insertStudent(Score score) {
        log.info("insertStudent start, request: " + score);
        score.setId(null);
        int i = studentMapper.insert(score);
        log.info("insertStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public String updateStudent(Score score) {
        log.info("updateStudent start, request: " + score);
        int i = studentMapper.updateById(score);
        log.info("updateStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public String deleteStudent(String id) {
        log.info("deleteStudent start, request: " + id);
        int i = studentMapper.deleteById(id);
        log.info("deleteStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public Map<String, String> getScoreInfor(ScoreInfoDto scoreInfoDto) {
        log.info("getScoreInfor start, request: " + scoreInfoDto);

        Map resultMap = new HashMap<>();
        LambdaQueryWrapper<Score> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(scoreInfoDto.getClasses())) {
            queryWrapper.eq(Score::getClasses, scoreInfoDto.getClasses());
        }
        if (StringUtils.isNotBlank(scoreInfoDto.getSubject())) {
            queryWrapper.eq(Score::getSubject, scoreInfoDto.getSubject());
        }
        if (StringUtils.isNotBlank(scoreInfoDto.getType())) {
            queryWrapper.eq(Score::getType, scoreInfoDto.getType());
        }

        List<Score> studentList = studentMapper.selectList(queryWrapper);

        List<String> scoreList = studentList.stream().map(Score::getScore).collect(Collectors.toList());
        if(scoreList.isEmpty()){
            resultMap.put("classes", scoreInfoDto.getClasses());
            resultMap.put("type", scoreInfoDto.getType());
            return resultMap;
        }
        String[] array = scoreList.toArray(new String[0]);
        int[] scoreInt = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();

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

    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public double getAvg(int[] arr) {
        double average = (double) getSum(arr) / arr.length;
        return average;
    }

    private double calculateMedian(int[] array) {
        Arrays.sort(array); //对数字进行排序
        int length = array.length;
        if (length % 2 == 0) {//2的倍数
            return ((double) array[length / 2 - 1] + array[length / 2]) / 2;
        } else {
            return array[length / 2];
        }
    }

}

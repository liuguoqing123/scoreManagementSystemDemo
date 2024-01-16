package com.demo.controller;


import com.demo.common.BaseResult;
import com.demo.domain.bo.Scores;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.vo.ScoreInfoVo;
import com.demo.domain.dto.StudentScoresListDto;
import com.demo.service.ScoresService;

import com.demo.common.BaseResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *@author:  lewis-Liu
 *@Description ScoresController
 */
@RestController
@Validated
@Slf4j
public class ScoresController {

    @Autowired
    private ScoresService scoresService;

    private static final String ERR_MSG = "errMsg";

    /**
     * 查询
     * @param request
     * @param studentListDto
     * @return
     */
    @PostMapping("/getScoresList")
    public BaseResult getScoresList(HttpServletRequest request, @RequestBody StudentScoresListDto studentListDto) {
        List<ScoreInfoVo> scoresList = scoresService.getScoresList(studentListDto);
        return BaseResultUtil.result(scoresList);
    }

    @PostMapping("/getStudentScoresInfo")
    public BaseResult getStudentScoresInfo(HttpServletRequest request, @RequestBody Map<String,String> scoresMap) {
        Scores scores  = scoresService.getStudentScoresInfo(scoresMap.get("id"));
        return BaseResultUtil.result(scores);
    }

    /**
     * 插入
     * @param request
     * @param scores
     * @return
     */
    @PostMapping("/insertStudentScores")
    public BaseResult insertStudentScores(HttpServletRequest request, @RequestBody Scores scores) {
        String resultInsert = scoresService.insertStudentScores(scores);
        Map resultMap = new HashMap<>();
        resultMap.put("message",resultInsert);
        return BaseResultUtil.result(resultMap);
    }

    /**
     * 更新
     * @param request
     * @param scores
     * @return
     */
    @PostMapping("/updateStudentScores")
    public BaseResult updateStudentScores(HttpServletRequest request, @RequestBody Scores scores) {
        String resultUpdate = scoresService.updateStudentScores(scores);
        Map resultMap = new HashMap<>();
        resultMap.put("message",resultUpdate);
        return BaseResultUtil.result(resultMap);
    }

    /**
     * 删除
     * @param request
     * @param student
     * @return
     */
    @PostMapping("/deleteStudentScores")
    public BaseResult deleteStudentScores(HttpServletRequest request, @RequestBody Map<String,String> student) {
        String resultDelete = scoresService.deleteStudentScores(student.get("id"));
        Map resultMap = new HashMap<>();
        resultMap.put("message",resultDelete);
        return BaseResultUtil.result(resultMap);
    }

    /**
     * 获取班级平均数和中位数
     * @param request
     * @param scoreInfoDto
     * @return
     */
    @PostMapping("/getAvgScoreInfor")
    public BaseResult getAvgScoreInfor(HttpServletRequest request, @RequestBody ScoreInfoDto scoreInfoDto) {
        Map resultMap = scoresService.getAvgScoreInfor(scoreInfoDto);
        return BaseResultUtil.result(resultMap);
    }
}

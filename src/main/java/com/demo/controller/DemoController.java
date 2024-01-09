package com.demo.controller;


import com.demo.common.BaseResult;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.dto.StudentListDto;
import com.demo.service.DemoService;

import com.demo.common.BaseResultUtil;
import com.demo.domain.bo.Score;
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
 *@Description DemoController
 */
@RestController
@Validated
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    private static final String ERR_MSG = "errMsg";

    /**
     * 查询
     * @param request
     * @param studentListDto
     * @return
     */
    @PostMapping("/getStudentList")
    public BaseResult getStudentList(HttpServletRequest request,@RequestBody StudentListDto studentListDto) {
        List<Score> userInfoList = demoService.getStudentList(studentListDto);
        return BaseResultUtil.result(userInfoList);
    }

    /**
     * 插入
     * @param request
     * @param score
     * @return
     */
    @PostMapping("/insertStudent")
    public BaseResult insertStudent(HttpServletRequest request, @RequestBody Score score) {
        String resultInsert = demoService.insertStudent(score);
        Map resultMap = new HashMap<>();
        resultMap.put("message",resultInsert);
        return BaseResultUtil.result(resultMap);
    }

    /**
     * 更新
     * @param request
     * @param score
     * @return
     */
    @PostMapping("/updateStudent")
    public BaseResult updateStudent(HttpServletRequest request, @RequestBody Score score) {
        String resultUpdate = demoService.updateStudent(score);
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
    @PostMapping("/deleteStudent")
    public BaseResult deleteUserInfo(HttpServletRequest request, @RequestBody Map<String,String> student) {
        String resultDelete = demoService.deleteStudent(student.get("id"));
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
    @PostMapping("/getScoreInfor")
    public BaseResult getScoreInfor(HttpServletRequest request, @RequestBody ScoreInfoDto scoreInfoDto) {
        Map resultMap = demoService.getScoreInfor(scoreInfoDto);
        return BaseResultUtil.result(resultMap);
    }
}

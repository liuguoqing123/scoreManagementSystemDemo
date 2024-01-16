package com.demo.controller;


import com.demo.common.BaseResult;
import com.demo.common.BaseResultUtil;
import com.demo.domain.bo.Students;
import com.demo.domain.dto.StudentListDto;
import com.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *@author:  lewis-Liu
 *@Description StudentController
 */
@RestController
@Validated
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    private static final String ERR_MSG = "errMsg";

    /**
     * 查询List
     * @param request
     * @param studentListDto
     * @return
     */
    @PostMapping("/getStudentList")
    public BaseResult getStudentList(HttpServletRequest request,@RequestBody StudentListDto studentListDto) {
        List<Students> studentList = studentService.getStudentList(studentListDto);
        return BaseResultUtil.result(studentList);
    }

    /**
     * 查询
     * @param request
     * @param scoresMap
     * @return
     */
    @PostMapping("/getStudentInfo")
    public BaseResult getStudentInfo(HttpServletRequest request, @RequestBody Map<String,String> scoresMap) {
        Students students  = studentService.getStudentInfo(scoresMap.get("stuNo"));
        return BaseResultUtil.result(students);
    }

    /**
     * 插入
     * @param request
     * @param students
     * @return
     */
    @PostMapping("/insertStudent")
    public BaseResult insertStudent(HttpServletRequest request, @RequestBody Students students) {
        String resultInsert = studentService.insertStudent(students);
        Map resultMap = new HashMap<>();
        resultMap.put("message",resultInsert);
        return BaseResultUtil.result(resultMap);
    }

    /**
     * 更新
     * @param request
     * @param students
     * @return
     */
    @PostMapping("/updateStudent")
    public BaseResult updateStudent(HttpServletRequest request, @RequestBody Students students) {
        String resultUpdate = studentService.updateStudent(students);
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
    public BaseResult deleteStudent(HttpServletRequest request, @RequestBody Map<String,String> student) {
        String resultDelete = studentService.deleteStudent(student.get("id"));
        Map resultMap = new HashMap<>();
        resultMap.put("message",resultDelete);
        return BaseResultUtil.result(resultMap);
    }

}

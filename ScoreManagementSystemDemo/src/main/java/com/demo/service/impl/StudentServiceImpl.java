package com.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.domain.bo.Students;
import com.demo.domain.dto.StudentListDto;
import com.demo.domain.mapper.StudentMapper;
import com.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Lewis Liu
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Students> getStudentList(StudentListDto studentListDto) {
        log.info("getStudentList start, request: " + studentListDto);
        LambdaQueryWrapper<Students> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(studentListDto.getClasses())){
            queryWrapper.eq(Students::getClasses,studentListDto.getClasses());
        }
        if(StringUtils.isNotEmpty(studentListDto.getName())){
            queryWrapper.eq(Students::getName,studentListDto.getName());
        }
        List<Students> studentList = studentMapper.selectList(queryWrapper);
        log.info("getStudentList end");
        return studentList;
    }


    @Override
    public Students getStudentInfo(String  studentNumber) {
        log.info("getStudentInfo start, request: " + studentNumber);
        LambdaQueryWrapper<Students> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Students::getStuNo,studentNumber);
        Students students = studentMapper.selectOne(queryWrapper);
        log.info("getStudentInfo end, result:" + students);
        return students;
    }

    @Override
    public String insertStudent(Students students) {
        log.info("insertStudent start, request: " + students);
        students.setId(null);
        int i = studentMapper.insert(students);
        log.info("insertStudent end, result:" + i);
        return i > 0 ? "success" : "failed";
    }

    @Override
    public String updateStudent(Students students) {
        log.info("updateStudent start, request: " + students);
        int i = studentMapper.updateById(students);
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

}

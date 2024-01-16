package com.demo.service;

import com.demo.domain.bo.Students;
import com.demo.domain.dto.StudentListDto;

import java.util.List;

/**
 * @author Lewis
 */
public interface StudentService {

    public List<Students> getStudentList(StudentListDto studentListDto);

    public Students getStudentInfo(String studentNumber);

    public String insertStudent(Students students);

    public String updateStudent(Students students);

    public String deleteStudent(String id);

}

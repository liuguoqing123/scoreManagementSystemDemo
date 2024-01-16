package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.domain.bo.Students;
import com.demo.domain.dto.StudentListDto;
import com.demo.domain.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentMapper mockStudentMapper;

    @InjectMocks
    private StudentServiceImpl studentServiceImplUnderTest;

    @Test
    void testGetStudentList() {
        // Setup
        final StudentListDto studentListDto = new StudentListDto();
        studentListDto.setName("lewis");
        studentListDto.setClasses("1");

        final Students students = new Students();
        students.setId("1");
        students.setStuNo("001");
        students.setName("lewis");
        students.setClasses("1");
        students.setDob("19921001");
        final List<Students> expectedResult = List.of(students);

        // Configure StudentMapper.selectList(...).
        final Students students2 = new Students();
        students2.setId("1");
        students2.setStuNo("001");
        students2.setName("lewis");
        students2.setClasses("1");
        students2.setDob("19921001");
        final List<Students> students1 = List.of(students2);
        when(mockStudentMapper.selectList(any(LambdaQueryWrapper.class))).thenReturn(students1);

        // Run the test
        final List<Students> result = studentServiceImplUnderTest.getStudentList(studentListDto);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetStudentList_StudentMapperReturnsNoItems() {
        // Setup
        final StudentListDto studentListDto = new StudentListDto();
        studentListDto.setName("lewis");
        studentListDto.setClasses("1");

        when(mockStudentMapper.selectList(any(LambdaQueryWrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<Students> result = studentServiceImplUnderTest.getStudentList(studentListDto);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetStudentInfo() {
        // Setup
        final Students expectedResult = new Students();
        expectedResult.setId("1");
        expectedResult.setStuNo("001");
        expectedResult.setName("lewis");
        expectedResult.setClasses("1");
        expectedResult.setDob("19921001");

        // Configure StudentMapper.selectOne(...).
        final Students students = new Students();
        students.setId("1");
        students.setStuNo("001");
        students.setName("lewis");
        students.setClasses("1");
        students.setDob("19921001");
        when(mockStudentMapper.selectOne(any(LambdaQueryWrapper.class))).thenReturn(students);

        // Run the test
        final Students result = studentServiceImplUnderTest.getStudentInfo("001");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testInsertStudent() {
        // Setup
        final Students students = new Students();
        students.setId("1");
        students.setStuNo("001");
        students.setName("lewis");
        students.setClasses("1");
        students.setDob("19921001");

        // Configure StudentMapper.insert(...).
        final Students entity = new Students();
        entity.setId("1");
        entity.setStuNo("001");
        entity.setName("lewis");
        entity.setClasses("1");
        entity.setDob("19921001");
        when(mockStudentMapper.insert(students)).thenReturn(1);

        // Run the test
        final String result = studentServiceImplUnderTest.insertStudent(students);

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testUpdateStudent() {
        // Setup
        final Students students = new Students();
        students.setId("1");
        students.setStuNo("001");
        students.setName("lewis");
        students.setClasses("1");
        students.setDob("19921001");

        // Configure StudentMapper.updateById(...).
        final Students entity = new Students();
        entity.setId("1");
        entity.setStuNo("001");
        entity.setName("lewis");
        entity.setClasses("1");
        entity.setDob("19921001");
        when(mockStudentMapper.updateById(entity)).thenReturn(1);

        // Run the test
        final String result = studentServiceImplUnderTest.updateStudent(students);

        // Verify the results
        assertThat(result).isEqualTo("success");
    }

    @Test
    void testDeleteStudent() {
        // Setup
        when(mockStudentMapper.deleteById("1")).thenReturn(1);

        // Run the test
        final String result = studentServiceImplUnderTest.deleteStudent("1");

        // Verify the results
        assertThat(result).isEqualTo("success");
    }
}

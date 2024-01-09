package com.demo.service;

import com.demo.domain.bo.Score;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.dto.StudentListDto;

import java.util.List;
import java.util.Map;

/**
 * @author Lewis
 */
public interface DemoService {

    public List<Score> getStudentList(StudentListDto studentListDto);

    public String insertStudent(Score score);

    public String updateStudent(Score score);

    public String deleteStudent(String id);

    public Map<String,String> getScoreInfor(ScoreInfoDto scoreInfoDto);


}

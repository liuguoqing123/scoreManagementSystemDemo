package com.demo.service;

import com.demo.domain.bo.Scores;
import com.demo.domain.dto.ScoreInfoDto;
import com.demo.domain.vo.ScoreInfoVo;
import com.demo.domain.dto.StudentScoresListDto;

import java.util.List;
import java.util.Map;

/**
 * @author Lewis
 */
public interface ScoresService {

    public List<ScoreInfoVo> getScoresList(StudentScoresListDto studentListDto);

    public Scores getStudentScoresInfo(String studentNumber);

    public String insertStudentScores(Scores scores);

    public String updateStudentScores(Scores scores);

    public String deleteStudentScores(String id);

    public Map getAvgScoreInfor(ScoreInfoDto scoreInfoDto);


}

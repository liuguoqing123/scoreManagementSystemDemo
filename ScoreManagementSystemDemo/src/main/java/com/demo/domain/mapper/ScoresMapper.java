package com.demo.domain.mapper;

import com.demo.domain.bo.Scores;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.domain.vo.ScoreInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Lewis
 */
@Repository
public interface ScoresMapper extends BaseMapper<Scores>{


    List<ScoreInfoVo> findScoreInfoList(@Param("type") String type, @Param("classes") String classes, @Param("name") String name);

    List<ScoreInfoVo> findAvgScoreInforlist(@Param("type") String type, @Param("classes") String classes, @Param("subject") String subject);



}

package com.demo.domain.mapper;

import com.demo.domain.bo.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Lewis
 */
@Repository
public interface StudentMapper extends BaseMapper<Score>{

}

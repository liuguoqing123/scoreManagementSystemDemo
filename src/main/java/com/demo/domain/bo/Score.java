package com.demo.domain.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Lewis
 */

@Data
@TableName(value = "score")
public class Score {

    @TableField("id")
    private String id;
    @TableField("stuNo")
    private String stuNo;//学号
    @TableField("name")
    private String name;//名字
    @TableField("score")
    private String score;//分数
    @TableField("type")
    private String type;//考试类型(期中考试,期末考试)
    @TableField("subject")
    private String subject;//考试科目(语文,数学)
    @TableField("classes")
    private String classes;//班级

}

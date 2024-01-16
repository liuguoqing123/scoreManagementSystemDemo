package com.demo.domain.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Lewis
 */

@Data
@TableName(value = "scores")
public class Scores implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;
    @TableField("subject")
    private String subject;//考试科目(语文,数学)
    @TableField("score")
    private Integer score;//分数
    @TableField("type")
    private String type;//考试类型(期中考试,期末考试)

    @TableField("stuNo")
    private String stuNo;//学号

    @TableField("create_by")
    String createBy;

    //@TableField("create_time")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField("update_by")
    String updateBy;

    //@TableField("update_time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

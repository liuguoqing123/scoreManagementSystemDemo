package com.demo.domain.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Lewis Liu
 * 学生表
 */
@Data
@TableName(value = "students")
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;
    @TableField("stuNo")
    private String stuNo;//学号
    @TableField("name")
    private String name;//名字
    @TableField("classes")
    private String classes;//班级
    @TableField("dob")
    private String dob;//出生年月

    @TableField("phone_number")
    private String phoneNumber;//手机号

    //@TableField("create_time")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField("update_by")
    String updateBy;

    //@TableField("update_time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

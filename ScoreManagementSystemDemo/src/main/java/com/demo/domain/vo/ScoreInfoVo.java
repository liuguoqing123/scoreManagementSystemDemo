package com.demo.domain.vo;

import lombok.Data;

/**
 * @Author Lewis Liu
 * @Version 1.0
 */
@Data
public class ScoreInfoVo {

    private String id;
    private String subject;//考试科目(语文,数学)
    private Integer score;//分数
    private String type;//考试类型(期中考试,期末考试)
    private String stuNo;//学号

    private String name;//名字
    private String classes;//班级

}

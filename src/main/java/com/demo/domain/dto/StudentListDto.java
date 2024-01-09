package com.demo.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @Author Lewis Liu
 * @Version 1.0
 */
@Data
public class StudentListDto {

    private String name;
    private String type;
    private String classes;

}

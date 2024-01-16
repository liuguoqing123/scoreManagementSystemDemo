package com.demo.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author Lewis Liu
 * @Version 1.0
 */
@Data
public class StudentScoresListDto {

    private String name;
    private String type;
    @NotEmpty(message = "classes not be empty")
    private String classes;

}

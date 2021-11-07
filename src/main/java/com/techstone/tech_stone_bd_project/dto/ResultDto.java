package com.techstone.tech_stone_bd_project.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Data
public class ResultDto {

    private Long resultId;

    @NotNull
    @Range(min = 0)
    private Double marks;
}

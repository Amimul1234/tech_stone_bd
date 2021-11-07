package com.techstone.tech_stone_bd_project.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Data
public class FeeDto {

    private Long feeId;

    @NotNull
    @Size(max = 500)
    private String feeName;

    @NotNull
    @Range(min = 0)
    private Double feeAmount;

    @NotNull
    private Boolean isEnabled;
}

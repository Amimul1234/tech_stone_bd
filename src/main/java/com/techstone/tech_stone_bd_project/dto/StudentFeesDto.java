package com.techstone.tech_stone_bd_project.dto;

import com.techstone.tech_stone_bd_project.model.FeeEntity;
import lombok.Data;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

@Data
public class StudentFeesDto {
    private Long id;
    private Long studentId;
    private FeeEntity feeEntity;
}

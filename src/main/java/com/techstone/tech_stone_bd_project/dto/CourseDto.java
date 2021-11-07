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
public class CourseDto {

    private Long courseId;

    @NotNull
    @Size(max = 400)
    private String name;

    @Size(max = 3000)
    private String description;

    @NotNull
    @Range(min = 0)
    private Double fullMarks;
}

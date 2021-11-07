package com.techstone.tech_stone_bd_project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Data
public class ClassRoomDto {

    private Long classId;

    @NotNull
    @Size(max = 500)
    private String className;

    @NotNull(message = "Group can not be null")
    private String group;

    @NotNull(message = "Section can not be null")
    private String section;

    private String remarks;
}

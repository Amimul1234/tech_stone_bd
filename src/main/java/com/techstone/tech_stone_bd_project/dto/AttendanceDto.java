package com.techstone.tech_stone_bd_project.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Data
public class AttendanceDto {

    private Long attendanceId;

    @NotNull
    private Date attendanceDate;

    @NotNull
    private Boolean isPresent;

    @Size(max = 500)
    private String remarks;
}

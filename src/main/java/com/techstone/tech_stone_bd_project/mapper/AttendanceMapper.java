package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.AttendanceDto;
import com.techstone.tech_stone_bd_project.model.AttendanceEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    AttendanceDto entityToDto( AttendanceEntity attendance );

    AttendanceEntity dtoToEntity( AttendanceDto attendanceDto );
}

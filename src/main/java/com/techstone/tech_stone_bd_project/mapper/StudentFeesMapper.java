package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.StudentFeesDto;
import com.techstone.tech_stone_bd_project.model.StudentFeesEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface StudentFeesMapper {
    StudentFeesDto entityToDto( StudentFeesEntity studentFeesEntity );
}

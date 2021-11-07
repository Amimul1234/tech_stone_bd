package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.CourseDto;
import com.techstone.tech_stone_bd_project.model.CourseEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto entityToDto( CourseEntity courseEntity );

    CourseEntity dtoToEntity( CourseDto courseDto );
}

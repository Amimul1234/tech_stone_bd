package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.StudentDto;
import com.techstone.tech_stone_bd_project.model.StudentEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto entityToDto( StudentEntity studentEntity );

    StudentEntity dtoToEntity( StudentDto studentDto );
}

package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.ExamDto;
import com.techstone.tech_stone_bd_project.model.ExamEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface ExamMapper {
    ExamDto entityToDto( ExamEntity examEntity );

    ExamEntity dtoToEntity( ExamDto examDto );
}

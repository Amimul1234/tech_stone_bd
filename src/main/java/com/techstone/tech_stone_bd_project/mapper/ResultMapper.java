package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.ResultDto;
import com.techstone.tech_stone_bd_project.model.ResultEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface ResultMapper {
    ResultEntity dtoToEntity( ResultDto resultDto );

    ResultDto entityToDto( ResultEntity resultEntity );
}

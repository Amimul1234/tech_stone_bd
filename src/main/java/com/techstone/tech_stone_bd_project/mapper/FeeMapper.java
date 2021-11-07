package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.FeeDto;
import com.techstone.tech_stone_bd_project.model.FeeEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface FeeMapper {
    FeeEntity dtoToEntity( FeeDto feeDto );

    FeeDto entityToDto( FeeEntity feeEntity );
}

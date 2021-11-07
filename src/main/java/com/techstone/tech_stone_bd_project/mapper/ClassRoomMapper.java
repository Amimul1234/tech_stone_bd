package com.techstone.tech_stone_bd_project.mapper;

import com.techstone.tech_stone_bd_project.dto.ClassRoomDto;
import com.techstone.tech_stone_bd_project.model.ClassRoomEntity;
import org.mapstruct.Mapper;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@Mapper(componentModel = "spring")
public interface ClassRoomMapper {
    ClassRoomEntity dtoToEntity( ClassRoomDto classRoomDto );

    ClassRoomDto entityToDto( ClassRoomEntity classRoomEntity );
}

package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ClassRoomDto;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

public interface ClassRoomService {
    CommonResponse createNewClass( ClassRoomDto classRoomDto );

    CommonResponse assignExamToClass( Long classId, Long examId );

    CommonResponse getAllClasses();
}

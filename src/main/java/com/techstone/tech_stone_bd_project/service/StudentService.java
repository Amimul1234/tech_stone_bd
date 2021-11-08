package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ClassRoomDto;
import com.techstone.tech_stone_bd_project.dto.StudentDto;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

public interface StudentService  {
    CommonResponse createNewStudentRecord( StudentDto studentDto );

    CommonResponse getAllGenders();

    CommonResponse getAllReligions();

    CommonResponse getAllGroups();

    CommonResponse getAllSections();
}

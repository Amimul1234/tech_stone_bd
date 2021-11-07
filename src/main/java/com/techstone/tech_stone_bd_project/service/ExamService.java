package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ExamDto;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

public interface ExamService {
    CommonResponse createNewExam( ExamDto examDto );

    CommonResponse updateExam( ExamDto examDto );

    CommonResponse assignCourseToExam( Long examId, Long courseId );
}

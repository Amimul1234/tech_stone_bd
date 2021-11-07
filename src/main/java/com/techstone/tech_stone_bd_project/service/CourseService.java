package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.CourseDto;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

public interface CourseService {
    CommonResponse createNewCourse( CourseDto courseDto );

    CommonResponse updateExistingCourse( CourseDto courseDto );

    CommonResponse assignResultToCourse( Long courseId, Long resultId );
}

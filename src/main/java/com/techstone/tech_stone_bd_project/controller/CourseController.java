package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.CourseDto;
import com.techstone.tech_stone_bd_project.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
@Api(tags = {"Course management APIs"})
public class CourseController {

    private final CourseService courseService;

    @PostMapping("admin/create-new-course")
    @ApiOperation(value = "Create a new course",
            notes = "To create a new course one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse createNewCourse( @Valid @RequestBody CourseDto courseDto ) {
        return courseService.createNewCourse(courseDto);
    }

    @PutMapping("admin/update-course")
    @ApiOperation(value = "Update an existing course",
            notes = "To update an existing course one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse updateExistingCourse( @Valid @RequestBody CourseDto courseDto ) {
        return courseService.updateExistingCourse(courseDto);
    }

    @PutMapping("admin/assign-result-to-course")
    @ApiOperation(value = "Assign result to exam",
            notes = "To assign result to course one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse assignResultToCourse( @RequestParam(name = "courseId") Long courseId,
                                              @RequestParam(name = "resultId") Long resultId ) {
        return courseService.assignResultToCourse(courseId, resultId);
    }
}

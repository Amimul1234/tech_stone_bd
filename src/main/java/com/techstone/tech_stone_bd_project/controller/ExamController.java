package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ExamDto;
import com.techstone.tech_stone_bd_project.service.ExamService;
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
@RequestMapping("api/v1/")
@RestController
@Api(tags = {"Exam management APIs"})
public class ExamController {

    private final ExamService examService;

    @PostMapping("admin/create-new-exam")
    @ApiOperation(value = "Create a new exam",
            notes = "To create a new exam one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse createNewExam( @Valid @RequestBody ExamDto examDto ) {
        return examService.createNewExam(examDto);
    }

    @PutMapping("admin/update-exam-name")
    @ApiOperation(value = "Update an existing exam name",
            notes = "To update exam name one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse updateExamName( @Valid @RequestBody ExamDto examDto ) {
        return examService.updateExamName(examDto);
    }
}

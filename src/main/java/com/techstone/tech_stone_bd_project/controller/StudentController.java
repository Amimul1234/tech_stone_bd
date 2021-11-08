package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.StudentDto;
import com.techstone.tech_stone_bd_project.service.StudentService;
import com.techstone.tech_stone_bd_project.service.storage.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
@Api(tags = {"Student management APIs"})
public class StudentController {

    private final StorageService storageService;
    private final StudentService studentService;

    @GetMapping("admin/get-available-genders")
    @ApiOperation(value = "Get all available gender",
            notes = "Get all available gender available in the system",
            response = CommonResponse.class)
    public CommonResponse getAllGenders() {
        return studentService.getAllGenders();
    }

    @GetMapping("admin/get-available-groups")
    @ApiOperation(value = "Get all available groups",
            notes = "Get all groups available in the system",
            response = CommonResponse.class)
    public CommonResponse getAllGroups() {
        return studentService.getAllGroups();
    }

    @GetMapping("admin/get-available-religions")
    @ApiOperation(value = "Get all available religions",
            notes = "Get all religion available in the system",
            response = CommonResponse.class)
    public CommonResponse getAllReligion() {
        return studentService.getAllReligions();
    }

    @GetMapping("admin/get-available-sections")
    @ApiOperation(value = "Get all available sections",
            notes = "Get all sections available in the system",
            response = CommonResponse.class)
    public CommonResponse getAllSections() {
        return studentService.getAllSections();
    }

    @PostMapping("admin/upload-student-picture")
    @ApiOperation(value = "Upload student picture",
            notes = "Must have the role 'ADMIN' to upload student picture" +
                    "(Receives multipart file named as student_picture)",
            response = CommonResponse.class)
    public CommonResponse uploadStudentProfilePicture( @RequestParam(value = "student_picture")
                                                               MultipartFile student_picture ) {
        return storageService.uploadMultipartImage("studentPictures", student_picture);
    }

    @PostMapping("admin/create-new-student-record")
    @ApiOperation(value = "Create a new student record",
            notes = "To create a new student record one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse createNewStudentRecord( @Valid @RequestBody StudentDto studentDto ) {
        return studentService.createNewStudentRecord(studentDto);
    }

    @GetMapping("admin/get-all-student-record")
    @ApiOperation(value = "Get all the student records",
            notes = "To get all student record one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse getAllStudentRecord( @RequestParam(name = "pageNumber") int pageNumber,
                                               @RequestParam(name = "pageSize") int pageSize ) {
        return studentService.getAllStudentRecord(pageNumber, pageSize);
    }

}

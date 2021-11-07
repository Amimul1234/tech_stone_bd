package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.mapper.StudentMapper;
import com.techstone.tech_stone_bd_project.repositories.StudentRepo;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final StudentRepo studentRepo;

    private final StudentMapper studentMapper;

    //TODO
}

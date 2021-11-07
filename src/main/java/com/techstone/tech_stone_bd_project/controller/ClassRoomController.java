package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.ClassRoomDto;
import com.techstone.tech_stone_bd_project.service.ClassRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@RequestMapping("api/v1/")
@RestController
@Api(tags = {"Class room management APIs"})
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    @PostMapping("admin/create-new-class")
    @ApiOperation(value = "Create a new class",
            notes = "To create a new class one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse createNewClass( @Valid @RequestBody ClassRoomDto classRoomDto ) {
        return classRoomService.createNewClass(classRoomDto);
    }


}

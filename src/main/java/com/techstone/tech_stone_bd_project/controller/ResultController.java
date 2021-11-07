package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.mapper.ResultMapper;
import com.techstone.tech_stone_bd_project.service.ResultService;
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
@Api(tags = {"Result management APIs"})
public class ResultController {
    private final ResultService resultService;

    private final ResultMapper resultMapper;

    //TODO
}

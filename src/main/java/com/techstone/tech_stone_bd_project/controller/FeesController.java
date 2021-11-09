package com.techstone.tech_stone_bd_project.controller;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.FeeDto;
import com.techstone.tech_stone_bd_project.service.FeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
@Api(tags = {"Fee management APIs"})
public class FeesController {

    private final FeeService feeService;

    @GetMapping("admin/get-all-fee-records")
    @ApiOperation(value = "Get all fee record",
            notes = "To get all fee records one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse getAllFeeRecords() {
        return feeService.getAllFeeRecords();
    }

    @PostMapping("admin/create-new-fee-record")
    @ApiOperation(value = "Create a new fee record",
            notes = "To create a new fee record one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse createNewStudentRecord( @Valid @RequestBody FeeDto feeDto ) {
        return feeService.createFeeDto(feeDto);
    }

    @PutMapping("admin/update-fee-record")
    @ApiOperation(value = "Update fee records",
            notes = "To update fee records one must have 'ADMIN' role",
            response = CommonResponse.class)
    public CommonResponse updateFeeRecords( @Valid @RequestBody FeeDto feeDto ) {
        return feeService.updateFeeRecords(feeDto);
    }
}

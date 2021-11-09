package com.techstone.tech_stone_bd_project.service;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.dto.FeeDto;

/**
 * @Author Amimul Ehsan
 * @Created at 11/9/21
 * @Project tech_stone_bd_project
 */

public interface FeeService {
    CommonResponse createFeeDto( FeeDto feeDto );

    CommonResponse getAllFeeRecords();

    CommonResponse updateFeeRecords( FeeDto feeDto );
}

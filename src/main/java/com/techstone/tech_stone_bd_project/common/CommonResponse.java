package com.techstone.tech_stone_bd_project.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@Data
@AllArgsConstructor
public class CommonResponse {
    private final HttpStatus responseCode;
    private final String message;
    private final Object payLoad;
}

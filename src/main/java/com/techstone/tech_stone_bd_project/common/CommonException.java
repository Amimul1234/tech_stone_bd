package com.techstone.tech_stone_bd_project.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@Data
public class CommonException {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timeStamp;

    private final HttpStatus responseCode;
    private final String message;
    private final String debugMessage;
}

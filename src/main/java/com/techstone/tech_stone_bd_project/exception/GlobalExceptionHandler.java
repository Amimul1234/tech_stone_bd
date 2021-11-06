package com.techstone.tech_stone_bd_project.exception;

import com.techstone.tech_stone_bd_project.common.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

/**
 * @Author Amimul Ehsan
 * @Created at 11/6/21
 * @Project tech_stone_bd_project
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> accountCreationException( MethodArgumentNotValidException argumentNotValidException ) {

        CommonException commonException = new CommonException(
                LocalDateTime.now(),
                UNPROCESSABLE_ENTITY,
                argumentNotValidException.getLocalizedMessage(),
                argumentNotValidException.toString()
        );

        return new ResponseEntity<>(commonException, UNPROCESSABLE_ENTITY);
    }

}

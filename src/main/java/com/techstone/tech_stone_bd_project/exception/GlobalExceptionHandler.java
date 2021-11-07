package com.techstone.tech_stone_bd_project.exception;

import com.techstone.tech_stone_bd_project.common.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

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

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentException( IllegalArgumentException illegalArgumentException ) {

        CommonException commonException = new CommonException(
                LocalDateTime.now(),
                UNPROCESSABLE_ENTITY,
                illegalArgumentException.getLocalizedMessage(),
                illegalArgumentException.toString()
        );

        return new ResponseEntity<>(commonException, UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<Object> alreadyExists( AlreadyExistsException alreadyExistsException ) {

        CommonException commonException = new CommonException(
                LocalDateTime.now(),
                CONFLICT,
                alreadyExistsException.getLocalizedMessage(),
                alreadyExistsException.toString()
        );

        return new ResponseEntity<>(commonException, CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> notFound( NotFoundException notFoundException ) {

        CommonException commonException = new CommonException(
                LocalDateTime.now(),
                NOT_FOUND,
                notFoundException.getLocalizedMessage(),
                notFoundException.toString()
        );

        return new ResponseEntity<>(commonException, NOT_FOUND);
    }

}

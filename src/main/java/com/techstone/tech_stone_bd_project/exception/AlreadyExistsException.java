package com.techstone.tech_stone_bd_project.exception;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException( String message ) {
        super(message);
    }
}

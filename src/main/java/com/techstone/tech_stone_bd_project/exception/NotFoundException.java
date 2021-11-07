package com.techstone.tech_stone_bd_project.exception;

/**
 * @Author Amimul Ehsan
 * @Created at 11/7/21
 * @Project tech_stone_bd_project
 */

public class NotFoundException extends RuntimeException{
    public NotFoundException( String message ) {
        super(message);
    }
}

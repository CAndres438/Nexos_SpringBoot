package com.auto_inventory_1.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class EmploymentInvalidAdvice {
    @ResponseBody
    @ExceptionHandler(EmploymentInvalidException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String EntityConflictAdvice (EmploymentInvalidException ex){
        return ex.getMessage();
    }
}

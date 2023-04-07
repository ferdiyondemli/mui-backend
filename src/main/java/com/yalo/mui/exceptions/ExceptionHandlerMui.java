package com.yalo.mui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerMui {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException userNotFoundException) {
        return userNotFoundException.getMessage();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleInvalidArgument(MethodArgumentNotValidException ex) {
        String message = "";

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            message += fieldError.getDefaultMessage();
        }


        return message;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleUniqueEmail(SQLIntegrityConstraintViolationException ex) {

        System.out.println("ex = " + ex);
        return "Aynı email ile kayıtlı kullanıcı bulunmaktadır.";
    }



}

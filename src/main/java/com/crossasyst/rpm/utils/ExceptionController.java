package com.crossasyst.rpm.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<Object> handleExceptions(CustomExceptionHandler exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Id Not Found");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

package com.example.getmesocialservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

//after adding this annotation, it can intercept your all resource, repository and service classes
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity<String> restrictedInfoError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementError(){
        return new ResponseEntity<>("no such element found", HttpStatus.CONFLICT);
    }






}

package com.umfg.mitsubishi.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorsAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<String>> handleException(BindException ex, WebRequest request){
        return ResponseEntity.badRequest().body(
                ex.getAllErrors().stream().map(ErrorsAdvice::errorToString).collect(Collectors.toList())
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleException(EntityNotFoundException ex, WebRequest request){
        return ResponseEntity.notFound().build();
    }

    private static String errorToString(ObjectError err){
        return err.getDefaultMessage();
    }

}

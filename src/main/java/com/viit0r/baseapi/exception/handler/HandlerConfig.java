package com.viit0r.baseapi.exception.handler;

import com.viit0r.baseapi.exception.ExceptionResponse;
import com.viit0r.baseapi.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handlePersonNotFound(Exception err) {
        ExceptionResponse notFoundResponse = new ExceptionResponse(err.getMessage());
        return new ResponseEntity<>(notFoundResponse, HttpStatus.NOT_FOUND);
    }
}

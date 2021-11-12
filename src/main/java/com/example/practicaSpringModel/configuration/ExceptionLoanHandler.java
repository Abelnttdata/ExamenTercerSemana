package com.example.practicaSpringModel.configuration;

import com.example.practicaSpringModel.controller.nonexistentLoanException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionLoanHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({nonexistentLoanException.class})
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex,"Loan not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}

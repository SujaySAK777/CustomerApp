package com.example.customerApp.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.customerApp.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

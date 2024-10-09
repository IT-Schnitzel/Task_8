package com.example.currencyconverter.exception;

import com.example.currencyconverter.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse(400, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(404, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleServiceUnavailable(RuntimeException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Retry-After", "3600");
        ErrorResponse errorResponse = new ErrorResponse(503, "Service unavailable, please try again later.");
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.SERVICE_UNAVAILABLE);
    }
}

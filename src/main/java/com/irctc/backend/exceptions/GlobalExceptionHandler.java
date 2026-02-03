package com.irctc.backend.exceptions;

import com.irctc.backend.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
//    pore project ka lie hai
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handelNoSuchElementException(NoSuchElementException exception)
    {
        ErrorResponse response= new ErrorResponse("Train not found !!" + exception.getMessage(), "404",false);
        ResponseEntity<ErrorResponse> responseResponseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return responseResponseEntity;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String, String> errorResponse = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
          String errorMessage=error.getDefaultMessage();
          String field=((FieldError)error).getField();
          errorResponse.put(field,errorMessage);        });
        ResponseEntity<Map<String, String>> error = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        return error;
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException exception)
    {
        ErrorResponse response= new ErrorResponse( exception.getMessage(), "404",false);
        ResponseEntity<ErrorResponse> responseResponseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return responseResponseEntity;
    }

}

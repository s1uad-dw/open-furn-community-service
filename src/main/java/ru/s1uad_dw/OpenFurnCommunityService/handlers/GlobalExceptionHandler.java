package ru.s1uad_dw.OpenFurnCommunityService.handlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.s1uad_dw.OpenFurnCommunityService.dtos.AppError;
import ru.s1uad_dw.OpenFurnCommunityService.extensions.*;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(new AppError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURL().toString()
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> catchInvalidDataException(InvalidDataException e, HttpServletRequest request) {
        return new ResponseEntity<>(new AppError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getRequestURL().toString()
        ), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<AppError> catchTokenExpiredException(TokenExpiredException e, HttpServletRequest request) {
        return new ResponseEntity<>(new AppError(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                e.getMessage(),
                request.getRequestURL().toString()
        ), HttpStatus.UNAUTHORIZED);
    }
}

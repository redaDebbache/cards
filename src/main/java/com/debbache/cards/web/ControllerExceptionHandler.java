package com.debbache.cards.web;

import com.debbache.cards.exception.InvalidGameId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidGameId.class)
    public ResponseEntity<ErrorResponse> invalidGameIdErrorResponse(InvalidGameId ex){
        return handleGenericException(ex, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> handleGenericException(Exception exception, HttpStatus httpStatus) {
        var errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    class ErrorResponse{
        private String message;
        private LocalDateTime timestamp;
    }

}

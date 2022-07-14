package com.akgarg.springbootemailsender.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 14-07-2022
 */
@RestControllerAdvice
public class EmailSenderExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        e.printStackTrace();
        Map<String, Object> errorMap = new HashMap<>();
        int errorStatus;

        switch (e.getClass().getSimpleName()) {
            case "HttpMessageNotReadableException":
                errorMap.put("error_message", "Invalid or bad request");
                errorMap.put("error_code", HttpStatus.BAD_REQUEST.value());
                errorStatus = HttpStatus.BAD_REQUEST.value();
                break;

            case "BadRequestException":
                errorMap.put("error_message", e.getMessage());
                errorMap.put("error_code", HttpStatus.BAD_REQUEST.value());
                errorStatus = HttpStatus.BAD_REQUEST.value();
                break;

            default:
                errorMap.put("error_message", "Server Error");
                errorMap.put("error_cause", e.getMessage());
                errorMap.put("error_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
                errorStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }

        errorMap.put("success", false);
        errorMap.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(errorStatus).body(errorMap);
    }

}

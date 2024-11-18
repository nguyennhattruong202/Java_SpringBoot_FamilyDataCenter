package com.nnt.fdcweb.controllers.exception;

import com.nimbusds.jose.JOSEException;
import com.nnt.fdcweb.dto.response.ApiResponse;
import com.nnt.fdcweb.enums.ResponseCode;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        ApiResponse<Map<String, String>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.VALIDATION_ERROR.getCode());
        apiResponse.setMessage(ResponseCode.VALIDATION_ERROR.name());
        apiResponse.setResult(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(JOSEException.class)
    public ResponseEntity<ApiResponse> handleJOSEException(JOSEException ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.CANNOT_GENERATE_TOKEN.getCode());
        apiResponse.setMessage(ResponseCode.CANNOT_GENERATE_TOKEN.name());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public void handleNoResourceFoundException(NoResourceFoundException ex) {

    }
}

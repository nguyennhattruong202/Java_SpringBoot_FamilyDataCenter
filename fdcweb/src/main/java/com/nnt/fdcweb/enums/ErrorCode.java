package com.nnt.fdcweb.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_NOT_EXISTS(901, "User not exists", HttpStatus.NOT_FOUND),
    VALIDATION_ERROR(903, "Validation error", HttpStatus.FORBIDDEN),
    PASSWORD_INCORRECT(904, "Password is incorrect", HttpStatus.UNAUTHORIZED),
    INVALID_CREDENTIALS(905, "Incorrect phone number or password", HttpStatus.UNAUTHORIZED);

    private ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
    private final int code;
    private final String message;
    private final HttpStatusCode httpStatusCode;
}

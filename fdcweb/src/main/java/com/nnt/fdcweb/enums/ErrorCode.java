package com.nnt.fdcweb.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    PASSWORD_INCORRECT(904, "Password is incorrect", HttpStatus.UNAUTHORIZED);

    private ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
    private final int code;
    private final String message;
    private final HttpStatusCode httpStatusCode;
}

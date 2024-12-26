package com.nnt.fdcweb.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ResponseCode {

    OK(700, "OK", HttpStatus.OK),
    AUTHENTICATED(701, "Authenticated", HttpStatus.OK),
    TOKEN_OK(702, "Token successful", HttpStatus.OK),
    USER_CREATED(703, "User created", HttpStatus.CREATED),
    ACCOUNT_CREATED(704, "Account created", HttpStatus.CREATED),
    UNAUTHENTICATED(900, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    NOT_EXISTS(901, "Not exists", HttpStatus.NOT_FOUND),
    TOKEN_INVALID(902, "Token invalid", HttpStatus.UNAUTHORIZED),
    VALIDATION_ERROR(903, "Validation error", HttpStatus.FORBIDDEN),
    CANNOT_GENERATE_TOKEN(1000, "Cannot Generate token", HttpStatus.INTERNAL_SERVER_ERROR);

    private ResponseCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
    private final Integer code;
    private final String message;
    private final HttpStatusCode httpStatusCode;
}

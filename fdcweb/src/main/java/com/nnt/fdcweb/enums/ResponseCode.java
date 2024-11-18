package com.nnt.fdcweb.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {

    AUTHENTICATED(700),
    OK(701),
    TOKEN_OK(702),
    UNAUTHENTICATED(900),
    NOT_EXISTS(901),
    INVALID_TOKEN(902),
    VALIDATION_ERROR(902),
    CANNOT_GENERATE_TOKEN(1000);

    private ResponseCode(int code) {
        this.code = code;
    }
    private final int code;
}

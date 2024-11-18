package com.nnt.fdcweb.controllers.exception;

import com.nnt.fdcweb.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends RuntimeException {

    private ResponseCode responseCode;

}

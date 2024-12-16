package com.nnt.fdcweb.controllers;

import com.nimbusds.jose.JOSEException;
import com.nnt.fdcweb.dto.request.AuthenticationRequest;
import com.nnt.fdcweb.dto.request.IntrospectRequest;
import com.nnt.fdcweb.dto.response.AuthenticationResponse;
import com.nnt.fdcweb.dto.response.IntrospectResponse;
import com.nnt.fdcweb.enums.ResponseCode;
import com.nnt.fdcweb.services.AuthenticationService;
import jakarta.validation.Valid;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/auth")
public class AuthenticationApiController {

//    @Autowired
//    private AuthenticationService authenticationService;

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
//        return ResponseEntity.status(HttpStatus.OK).body(this.authenticationService.authenticate(authenticationRequest));
//    }

//    @RequestMapping(value = "/introspect", method = RequestMethod.POST)
//    public ResponseEntity<IntrospectResponse> introspect(@Valid @RequestBody IntrospectRequest introspectRequest) throws JOSEException, ParseException {
//        IntrospectResponse introspectResponse = this.authenticationService.introspect(introspectRequest);
//        if (introspectResponse.getCode() == ResponseCode.TOKEN_OK.getCode()) {
//            return ResponseEntity.status(HttpStatus.OK).body(introspectResponse);
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(introspectResponse);
//    }
}

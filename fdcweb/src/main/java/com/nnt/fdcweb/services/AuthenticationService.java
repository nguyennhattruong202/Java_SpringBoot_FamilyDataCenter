package com.nnt.fdcweb.services;

import com.nimbusds.jose.JOSEException;
import com.nnt.fdcweb.dto.request.AuthenticationRequest;
import com.nnt.fdcweb.dto.request.IntrospectRequest;
import com.nnt.fdcweb.dto.response.AuthenticationResponse;
import com.nnt.fdcweb.dto.response.IntrospectResponse;
import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    IntrospectResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException;

}

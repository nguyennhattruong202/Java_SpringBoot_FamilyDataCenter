package com.nnt.fdcweb.services;

import com.nnt.fdcweb.dto.request.AuthCredentialsRequest;
import com.nnt.fdcweb.dto.request.SignInRequest;
import com.nnt.fdcweb.dto.response.AuthCredentialsResponse;
import com.nnt.fdcweb.entity.User;

public interface AuthCredentialsService {

    AuthCredentialsResponse createPassword(String userId, AuthCredentialsRequest authCredentialsRequest);

    User signIn(SignInRequest signInRequest);

}

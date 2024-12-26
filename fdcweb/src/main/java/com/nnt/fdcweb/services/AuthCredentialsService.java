package com.nnt.fdcweb.services;

import com.nnt.fdcweb.dto.request.AuthCredentialsRequest;
import com.nnt.fdcweb.dto.request.LoginRequest;
import com.nnt.fdcweb.dto.response.AuthCredentialsResponse;
import com.nnt.fdcweb.entity.User;

public interface AuthCredentialsService {

    AuthCredentialsResponse createPassword(String userId, AuthCredentialsRequest authCredentialsRequest);

    User login(LoginRequest loginRequest);

}

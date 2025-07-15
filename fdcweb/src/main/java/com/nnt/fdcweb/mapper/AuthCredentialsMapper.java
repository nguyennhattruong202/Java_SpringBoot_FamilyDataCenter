package com.nnt.fdcweb.mapper;

import com.nnt.fdcweb.dto.request.AuthCredentialsRequest;
import com.nnt.fdcweb.dto.response.AuthCredentialsResponse;
import com.nnt.fdcweb.entity.AuthCredentials;
import com.nnt.fdcweb.entity.User;

public class AuthCredentialsMapper {

    public static AuthCredentials toAuthCredentials(User user,
            AuthCredentialsRequest authCredentialsRequest) {
        AuthCredentials authCredentials = new AuthCredentials();
        authCredentials.setPhone(authCredentialsRequest.getPhone());
        authCredentials.setPassword(authCredentialsRequest.getPassword());
        authCredentials.setUser(user);
        return authCredentials;
    }

    public static AuthCredentialsResponse toAuthCredentialsResponse(
            AuthCredentials authCredentials) {
        AuthCredentialsResponse authCredentialsResponse = new AuthCredentialsResponse();
        authCredentialsResponse.setUser(authCredentials.getUser());
        authCredentialsResponse.setPhone(authCredentials.getPhone());
        authCredentialsResponse.setPassword(authCredentials.getPassword());
        return authCredentialsResponse;
    }
}

package com.nnt.fdcweb.services;

import com.nnt.fdcweb.dto.request.CreateAccountRequest;
import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.CreateAccountResponse;
import com.nnt.fdcweb.dto.response.UserResponse;
import java.util.List;

public interface UserService {

    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);

    CreateAccountResponse findById(String id);

    UserResponse create(UserRequest userRequest);

    List<UserResponse> findAll();

    UserResponse update(String id, UserRequest userRequest);

    void delete(String id);
}

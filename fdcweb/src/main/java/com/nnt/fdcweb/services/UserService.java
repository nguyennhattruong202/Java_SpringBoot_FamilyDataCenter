package com.nnt.fdcweb.services;

import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.UserResponse;
import java.util.List;

public interface UserService {

    UserResponse create(UserRequest userRequest);

    List<UserResponse> findAll();
    
    UserResponse update(Long userId, UserRequest userRequest);
}

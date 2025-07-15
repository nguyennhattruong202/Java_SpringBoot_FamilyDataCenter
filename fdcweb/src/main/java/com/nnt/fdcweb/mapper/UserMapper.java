package com.nnt.fdcweb.mapper;

import com.nnt.fdcweb.dto.request.CreateAccountRequest;
import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.CreateAccountResponse;
import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.entity.User;

public class UserMapper {

    public static User toUser(CreateAccountRequest createAccountRequest) {
        User user = new User();
        user.setFullname(createAccountRequest.getFullname());
        user.setGender(createAccountRequest.getGender());
        user.setDateOfBirth(createAccountRequest.getDateOfBirth());
        user.setPhone(createAccountRequest.getPhone());
        return user;
    }

    public static CreateAccountResponse toCreateAccountResponse(User user) {
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setId(user.getId());
        createAccountResponse.setFullname(user.getFullname());
        createAccountResponse.setGender(user.getGender());
        createAccountResponse.setDateOfBirth(user.getDateOfBirth());
        createAccountResponse.setPhone(user.getPhone());
        return createAccountResponse;
    }

    public static User toUser(UserRequest userRequest) {
        User user = new User();
        user.setFullname(userRequest.getFullname());
        user.setGender(userRequest.getGender());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setCitizenIdentificationNumber(userRequest.getCitizenIdentificationNumber());
        user.setAddress(userRequest.getAddress());
        user.setNote(userRequest.getNote());
        return user;
    }

    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFullname(user.getFullname());
        userResponse.setGender(user.getGender());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setCitizenIdentificationNumber(user.getCitizenIdentificationNumber());
        userResponse.setAddress(user.getAddress());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        userResponse.setNote(user.getNote());
        return userResponse;
    }
}

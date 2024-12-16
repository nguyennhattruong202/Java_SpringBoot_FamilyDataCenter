package com.nnt.fdcweb.mapper;

import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.entity.User;

public class UserMapper {

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

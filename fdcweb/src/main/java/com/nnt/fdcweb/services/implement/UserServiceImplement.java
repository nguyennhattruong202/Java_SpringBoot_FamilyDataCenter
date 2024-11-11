package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.enums.UserRole;
import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.UserService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImplement implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        LocalDateTime datetime = LocalDateTime.now();
        user.setFullname(userRequest.getFullname());
        user.setGender(userRequest.getGender());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setID(userRequest.getID());
        user.setAddress(userRequest.getAddress());
        user.setPassword(userRequest.getPassword());
        user.setRole(UserRole.USER.name());
        user.setCreatedDate(datetime);
        user.setUpdatedDate(datetime);
        user.setNote(userRequest.getNote());
        User userSaved = this.userRepository.save(user);
        return UserResponse.builder()
                .userId(userSaved.getUserId())
                .fullname(userSaved.getFullname())
                .gender(userSaved.getGender())
                .dateOfBirth(userSaved.getDateOfBirth())
                .phone(userSaved.getPhone())
                .email(userSaved.getEmail())
                .ID(userSaved.getID())
                .address(userSaved.getAddress())
                .role(userSaved.getRole())
                .createdDate(userSaved.getCreatedDate())
                .updatedDate(userSaved.getUpdatedDate())
                .note(userSaved.getNote())
                .build();
    }
    
    @Override
    public List<UserResponse> findAll() {
        List<User> users = this.userRepository.findAll();
        List<UserResponse> usersResponse = new ArrayList<>();
        users.forEach(user -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setFullname(user.getFullname());
            userResponse.setGender(user.getGender());
            userResponse.setPhone(user.getPhone());
            userResponse.setDateOfBirth(user.getDateOfBirth());
            userResponse.setEmail(user.getEmail());
            userResponse.setID(user.getID());
            userResponse.setAddress(user.getAddress());
            userResponse.setRole(user.getRole());
            userResponse.setCreatedDate(user.getCreatedDate());
            userResponse.setUpdatedDate(user.getUpdatedDate());
            userResponse.setNote(user.getNote());
            usersResponse.add(userResponse);
        });
        return usersResponse;
    }
    
    @Override
    public UserResponse update(Long userId, UserRequest userRequest) {
        User user = this.userRepository.findById(userId).get();
        user.setFullname(userRequest.getFullname());
        user.setGender(userRequest.getGender());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setID(userRequest.getID());
        user.setAddress(userRequest.getAddress());
        user.setPassword(userRequest.getPassword());
        user.setNote(userRequest.getNote());
        user.setUpdatedDate(LocalDateTime.now());
        User userSaved = this.userRepository.save(user);
        return UserResponse.builder()
                .userId(userSaved.getUserId())
                .fullname(userSaved.getFullname())
                .gender(userSaved.getGender())
                .dateOfBirth(userSaved.getDateOfBirth())
                .phone(userSaved.getPhone())
                .email(userSaved.getEmail())
                .ID(userSaved.getID())
                .address(userSaved.getAddress())
                .role(userSaved.getRole())
                .createdDate(userSaved.getCreatedDate())
                .updatedDate(userSaved.getUpdatedDate())
                .note(userSaved.getNote())
                .build();
    }
    
}

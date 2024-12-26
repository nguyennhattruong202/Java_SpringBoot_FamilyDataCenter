package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.dto.request.CreateAccountRequest;
import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.CreateAccountResponse;
import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.mapper.UserMapper;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.UserService;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        User user = UserMapper.toUser(createAccountRequest);
        return UserMapper.toCreateAccountResponse(userRepository.save(user));
    }

    @Override
    public CreateAccountResponse findById(String id) {
        User user = userRepository.findById(id).get();
        return UserMapper.toCreateAccountResponse(user);
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = UserMapper.toUser(userRequest);
        return UserMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        userList.forEach(user -> {
            UserResponse userResponse = UserMapper.toUserResponse(user);
            userResponseList.add(userResponse);
        });
        return userResponseList;
    }

    @Override
    public UserResponse update(String id, UserRequest userRequest) {
        User user = userRepository.findById(id).get();
        user.setFullname(userRequest.getFullname());
        user.setGender(userRequest.getGender());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setCitizenIdentificationNumber(userRequest.getCitizenIdentificationNumber());
        user.setAddress(userRequest.getAddress());
        user.setNote(userRequest.getNote());
        return UserMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

}

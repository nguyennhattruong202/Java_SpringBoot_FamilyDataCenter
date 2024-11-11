package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.ApiResponse;
import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.services.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody UserRequest userRequest) {
        ApiResponse<UserResponse> userResponse = new ApiResponse<>();
        try {
            userResponse.setCode(HttpStatus.CREATED.value());
            userResponse.setMessage("User created");
            userResponse.setResult(this.userService.create(userRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        } catch (Exception e) {
            userResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            userResponse.setMessage("Server error");
            log.error("Error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
        }
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser() {
        ApiResponse<List<UserResponse>> userResponse = new ApiResponse<>();
        try {
            userResponse.setCode(HttpStatus.OK.value());
            userResponse.setMessage("Get all user");
            userResponse.setResult(this.userService.findAll());
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } catch (Exception e) {
            userResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            userResponse.setMessage("Server error");
            log.error("Error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
        }
    }

    @RequestMapping(value = "/user/update/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse<UserResponse>> update(@PathVariable(value = "userId") Long userId,
            @RequestBody UserRequest userRequest) {
        ApiResponse<UserResponse> userResponse = new ApiResponse<>();
        try {
            userResponse.setCode(HttpStatus.OK.value());
            userResponse.setMessage("User updated");
            userResponse.setResult(this.userService.update(userId, userRequest));
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } catch (Exception e) {
            userResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            userResponse.setMessage("Server error");
            log.error("Error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
        }
    }
}

package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.dto.request.CreateAccountRequest;
import com.nnt.fdcweb.dto.request.UserRequest;
import com.nnt.fdcweb.dto.response.ApiResponse;
import com.nnt.fdcweb.dto.response.CreateAccountResponse;
import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.enums.ResponseCode;
import com.nnt.fdcweb.services.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiUserController {

    private final UserService userService;

    public ApiUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/create-account")
    public ResponseEntity<ApiResponse<CreateAccountResponse>> createAccount(@Valid
            @RequestBody CreateAccountRequest createAccountRequest) {
        ApiResponse<CreateAccountResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.ACCOUNT_CREATED.getCode());
        apiResponse.setMessage(ResponseCode.ACCOUNT_CREATED.getMessage());
        apiResponse.setData(userService.createAccount(createAccountRequest));
        return ResponseEntity.status(ResponseCode.ACCOUNT_CREATED.getHttpStatusCode())
                .body(apiResponse);
    }

    @GetMapping(value = "/user/all")
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAll() {
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.OK.getCode());
        apiResponse.setMessage(ResponseCode.OK.getMessage());
        apiResponse.setData(userService.findAll());
        return ResponseEntity.status(ResponseCode.OK.getHttpStatusCode())
                .body(apiResponse);
    }

    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> update(@PathVariable(value = "id") String id,
            @RequestBody UserRequest userRequest) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.OK.getCode());
        apiResponse.setMessage(ResponseCode.OK.getMessage());
        apiResponse.setData(userService.update(id, userRequest));
        return ResponseEntity.status(ResponseCode.OK.getHttpStatusCode()).body(apiResponse);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable(value = "id") String id) {
        userService.delete(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.OK.getCode());
        apiResponse.setMessage(ResponseCode.OK.getMessage());
        apiResponse.setData("User deleted");
        return ResponseEntity.status(ResponseCode.OK.getHttpStatusCode()).body(apiResponse);
    }
}

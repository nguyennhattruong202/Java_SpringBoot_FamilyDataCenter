package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.dto.request.AuthCredentialsRequest;
import com.nnt.fdcweb.dto.request.SignInRequest;
import com.nnt.fdcweb.dto.response.ApiResponse;
import com.nnt.fdcweb.dto.response.AuthCredentialsResponse;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.enums.ResponseCode;
import com.nnt.fdcweb.services.AuthCredentialsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiAuthCredentialsController {

    private final AuthCredentialsService authCredentialsService;

    public ApiAuthCredentialsController(AuthCredentialsService authCredentialsService) {
        this.authCredentialsService = authCredentialsService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<ApiResponse<User>> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        ApiResponse<User> apiResponse = new ApiResponse();
        apiResponse.setCode(ResponseCode.OK.getCode());
            apiResponse.setMessage(ResponseCode.OK.getMessage());
        apiResponse.setData(authCredentialsService.signIn(signInRequest));
        return ResponseEntity.status(ResponseCode.OK.getHttpStatusCode()).body(apiResponse);
    }

    @PostMapping(value = "/auth-credentials/{userId}")
    public ResponseEntity<ApiResponse<AuthCredentialsResponse>> createPassword(@PathVariable(value = "userId") String userId, @Valid @RequestBody AuthCredentialsRequest authCredentialsRequest) {
        ApiResponse<AuthCredentialsResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ResponseCode.OK.getCode());
        apiResponse.setMessage(ResponseCode.OK.getMessage());
        apiResponse.setData(authCredentialsService.createPassword(userId, authCredentialsRequest));
        return ResponseEntity.status(ResponseCode.OK.getHttpStatusCode()).body(apiResponse);
    }
}

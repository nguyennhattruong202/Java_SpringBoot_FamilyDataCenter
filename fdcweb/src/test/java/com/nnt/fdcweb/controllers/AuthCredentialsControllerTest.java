package com.nnt.fdcweb.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnt.fdcweb.controllers.exception.AppException;
import com.nnt.fdcweb.dto.request.SignInRequest;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.enums.ErrorCode;
import com.nnt.fdcweb.services.AuthCredentialsService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/test.properties")
@Disabled
public class AuthCredentialsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthCredentialsService authCredentialsService;
    private SignInRequest loginSuccessRequest;
    private SignInRequest loginFailRequest;
    private User user;

    @BeforeEach
    void initLoginSuccessRequest() {
        loginSuccessRequest = new SignInRequest();
        loginSuccessRequest.setPhone("0865111466");
        loginSuccessRequest.setPassword("12345678");
    }

    @BeforeEach
    void initLoginFailRequest() {
        loginFailRequest = new SignInRequest();
        loginFailRequest.setPhone("0865111466");
        loginFailRequest.setPassword("12345677");
    }

    @BeforeEach
    void initUser() {
        user = new User();
        user.setId("c47e9e41-5a1c-40aa-b1c8-34cecb6e88ef");
        user.setFullname("Nguyễn Hưng");
        user.setGender("Nam");
        user.setDateOfBirth(LocalDate.of(2024, Month.DECEMBER, 24));
        user.setPhone("0865111466");
        user.setEmail(null);
        user.setCitizenIdentificationNumber(null);
        user.setAddress(null);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setNote(null);
    }

    @Test
    void loginSuccess() throws JsonProcessingException, Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(loginSuccessRequest);
        Mockito.when(authCredentialsService.signIn(loginSuccessRequest)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(700));
    }

    @Test
    void loginFail() throws JsonProcessingException, Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(loginFailRequest);
        Mockito.when(authCredentialsService.signIn(loginFailRequest))
                .thenThrow(new AppException(ErrorCode.INVALID_CREDENTIALS));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(905));
    }
}

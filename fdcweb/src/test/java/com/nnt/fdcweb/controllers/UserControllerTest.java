package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.dto.response.UserResponse;
import com.nnt.fdcweb.services.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void findAll_whenNoException_thenUserResponseList() throws Exception {
        UserResponse userResponse1 = new UserResponse();
        userResponse1.setId(UUID.randomUUID().toString());
        userResponse1.setFullname("Nguyen Van A");
        userResponse1.setGender("Nam");
        userResponse1.setDateOfBirth(LocalDate.now());
        userResponse1.setPhone("0865761885");
        userResponse1.setCreatedAt(LocalDateTime.now());
        userResponse1.setUpdatedAt(LocalDateTime.now());
        log.info("UUID user response 1: {}", userResponse1.getId());

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setId(UUID.randomUUID().toString());
        userResponse2.setFullname("Nguyen Thi B");
        userResponse2.setGender("Nu");
        userResponse2.setDateOfBirth(LocalDate.now());
        userResponse2.setPhone("0865761886");
        userResponse2.setCreatedAt(LocalDateTime.now());
        userResponse2.setUpdatedAt(LocalDateTime.now());
        log.info("UUID user response 2: {}", userResponse2.getId());

        List<UserResponse> userResponseList = new ArrayList<>();
        userResponseList.add(userResponse1);
        userResponseList.add(userResponse2);

        Mockito.when(userService.findAll()).thenReturn(userResponseList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/all")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(700))
                .andExpect(MockMvcResultMatchers.jsonPath("data[0].fullname")
                        .value("Nguyen Van A"));
    }
}

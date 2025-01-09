package com.nnt.fdcweb.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthCredentialsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSignUpEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sign-up"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/public/sign-up"));
    }

    @Test
    public void testSignInEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sign-in"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/public/sign-in"));
    }
}

package com.nnt.fdcweb.service;

import com.nnt.fdcweb.dto.request.LoginRequest;
import com.nnt.fdcweb.entity.AuthCredentials;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.repository.AuthCredentialsRepository;
import com.nnt.fdcweb.services.implement.AuthCredentialsServiceImplement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/test.properties")
@ExtendWith(MockitoExtension.class)
@Slf4j
public class AuthCredentialsServiceTest {

    @Mock
    private AuthCredentialsRepository authCredentialsRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthCredentialsServiceImplement authCredentialsServiceImplement;

    @Test
    void login_whenCredentialsValid_thenReturnUser() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPhone("0865111466");
        loginRequest.setPassword("12345678");

        User user = new User();
        user.setId("c47e9e41-5a1c-40aa-b1c8-34cecb6e88ef");
        user.setFullname("Nguyen Bang");
        user.setGender("Nam");
        user.setDateOfBirth(LocalDate.now());
        user.setPhone("0865111466");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        AuthCredentials authCredentials = new AuthCredentials();
        authCredentials.setId(1L);
        authCredentials.setPhone("0865111466");
        authCredentials.setPassword("$2a$10$encodedPasswordHash");
        authCredentials.setUser(user);
        authCredentials.setCreatedAt(LocalDateTime.now());
        authCredentials.setUpdatedAt(LocalDateTime.now());

        Mockito.when(authCredentialsRepository.findByPhone(loginRequest.getPhone()))
                .thenReturn(Optional.of(authCredentials));
        Mockito.when(passwordEncoder.matches(loginRequest.getPassword(),
                authCredentials.getPassword())).thenReturn(true);

        User userAfterLogin = authCredentialsServiceImplement.login(loginRequest);
        log.info("User after login: {}", userAfterLogin.toString());

        Mockito.verify(authCredentialsRepository).findByPhone(loginRequest.getPhone());
        Mockito.verify(passwordEncoder).matches(loginRequest.getPassword(),
                authCredentials.getPassword());
        Assertions.assertNotNull(userAfterLogin);
        Assertions.assertEquals(userAfterLogin.getId(), user.getId());
        Assertions.assertEquals(userAfterLogin.getFullname(), user.getFullname());
    }
}

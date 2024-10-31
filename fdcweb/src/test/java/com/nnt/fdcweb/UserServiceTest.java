package com.nnt.fdcweb;

import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.implement.UserServiceImplement;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private UserServiceImplement userServiceImplement;

    @Test
    public void testPasswordEncoding() {
        String password = "123456";
        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");
        String passwordEncode = passwordEncoder.encode(password);
        Assertions.assertEquals("encodedPassword", passwordEncode);
        Assertions.assertNotEquals(password, passwordEncode);
    }

    @Test
    public void testCreateUserSuccess() {
        User user = new User();
        user.setFullname("Nguyen Nhat Truong");
        user.setGender("Nam");
        user.setDateOfBirth(LocalDate.now());
        user.setPhone("0987665761");
        user.setPassword("123456");
        when(this.userRepository.save(user)).thenReturn(user);
        User savedUser = this.userServiceImplement.createUser(user);
        System.out.println("User: " + savedUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals("Nguyen Nhat Truong", savedUser.getFullName());
    }
}

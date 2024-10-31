package com.nnt.fdcweb;

import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.implement.UserServiceImplement;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImplement userServiceImplement;

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
        Assertions.assertEquals("Nguyen Nhat Truong", savedUser.getFullName());
    }
}

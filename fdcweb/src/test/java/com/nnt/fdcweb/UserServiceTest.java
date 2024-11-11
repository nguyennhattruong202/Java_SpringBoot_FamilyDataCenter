package com.nnt.fdcweb;

//import com.nnt.fdcweb.model.User;
//import com.nnt.fdcweb.repository.UserRepository;
//import com.nnt.fdcweb.services.implement.UserServiceImplement;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class UserServiceTest {

//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserServiceImplement userServiceImplement;
//
//    @Test
//    public void testCreateUserSuccess() {
//        User user = new User();
//        user.setFullname("Nguyen Nhat Truong");
//        user.setGender("Nam");
//        user.setDateOfBirth(LocalDate.now());
//        user.setPhone("0987665761");
//        user.setPassword("123456");
//        when(this.userRepository.save(user)).thenReturn(user);
//        User savedUser = this.userServiceImplement.createUser(user);
//        System.out.println("User: " + savedUser);
//        Assertions.assertEquals("Nguyen Nhat Truong", savedUser.getFullname());
//    }
//
//    @Test
//    public void testGetAllUser() {
//        User user1 = new User();
//        user1.setFullname("User 1");
//        user1.setGender("Nam");
//        user1.setDateOfBirth(LocalDate.now());
//        user1.setPhone("0988762611");
//        user1.setPassword("123456");
//        User user2 = new User();
//        user2.setFullname("User 1");
//        user2.setGender("Nam");
//        user2.setDateOfBirth(LocalDate.now());
//        user2.setPhone("0988762611");
//        user2.setPassword("123456");
//        when(this.userRepository.save(user1)).thenReturn(user1);
//        when(this.userRepository.save(user2)).thenReturn(user2);
//        User userSaved1 = this.userServiceImplement.createUser(user1);
//        User userSaved2 = this.userServiceImplement.createUser(user2);
//        when(this.userRepository.findAll()).thenReturn(Arrays.asList(userSaved1, userSaved2));
//        List<User> getListUser = this.userServiceImplement.findAll();
//        System.out.println("User 1: " + getListUser.get(0).getFullname());
//        Assertions.assertEquals("User 1", getListUser.get(0).getFullname());
//    }
}

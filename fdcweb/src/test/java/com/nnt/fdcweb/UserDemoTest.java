package com.nnt.fdcweb;

import com.nnt.fdcweb.model.UserDemo;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDemoTest {

    @Test
    public void showUserDemo() {
        UserDemo userDemo = new UserDemo();
        userDemo.setRole("ROLE_USER");
        userDemo.setFullname("Demo 1");
        userDemo.setEmail("demo1@gmail.com");
        userDemo.setDateOfBirth(LocalDate.now());
        userDemo.setPassword("123333");
        userDemo.setPassword("111111111");
        System.out.println(userDemo);
    }
}

package com.nnt.fdcweb.config;

import com.nnt.fdcweb.enums.UserRole;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class ApplicationInitConfig {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Bean
    public ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByPhone("0865761892").isEmpty()) {
                User user = new User();
                user.setFullname("admin");
                user.setGender("Nam");
                user.setDateOfBirth(LocalDate.parse("2001-02-20"));
                user.setPhone("0865761892");
                user.setEmail("nhattruongnguyen202@gmail.com");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setRole(UserRole.ADMIN.name());
                user.setCreatedDate(LocalDateTime.now());
                user.setUpdatedDate(LocalDateTime.now());
                User userSaved = userRepository.save(user);
                log.warn("Admin has been created with phone number is: " + userSaved.getPhone() + " and password is admin");
            }
        };
    }
}

package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.UserService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImplement implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User createUser(User user) {
        try {
            LocalDateTime datetime = LocalDateTime.now();
            String passwordEncode = passwordEncoder.encode(user.getPassword());
            user.setPassword(passwordEncode);
            user.setRole("user");
            user.setCreatedDate(datetime);
            user.setUpdatedDate(datetime);
            return userRepository.save(user);
        } catch (Exception e) {
            System.out.println("An exception occurred during create user: " + e.getMessage());
            throw new RuntimeException("An exception occurred during create user");
        }
    }
    
}

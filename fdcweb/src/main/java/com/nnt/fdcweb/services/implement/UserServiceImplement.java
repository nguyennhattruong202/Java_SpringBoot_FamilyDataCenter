package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.UserService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        LocalDateTime datetime = LocalDateTime.now();
        user.setRole("ROLE_USER");
        user.setCreatedDate(datetime);
        user.setUpdatedDate(datetime);
        return userRepository.save(user);
    }

}

package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.UserService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Integer page) {
        Pageable pagealble = PageRequest.of(page, 2, Sort.by("fullname").ascending());
        return this.userRepository.findAll(pagealble);
    }

}

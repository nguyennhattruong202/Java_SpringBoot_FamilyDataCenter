package com.nnt.fdcweb.services;

import com.nnt.fdcweb.model.User;
import java.util.List;
import org.springframework.data.domain.Page;

public interface UserService {

    User createUser(User user);

    List<User> findAll();

    Page<User> findAll(Integer page);
}

package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.model.User;
import com.nnt.fdcweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createUser = this.userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

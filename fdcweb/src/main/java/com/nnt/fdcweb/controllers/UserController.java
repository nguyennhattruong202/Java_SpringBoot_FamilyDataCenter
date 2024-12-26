package com.nnt.fdcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/create-account")
    public String createAccount() {
        return "/public/create-account";
    }
}

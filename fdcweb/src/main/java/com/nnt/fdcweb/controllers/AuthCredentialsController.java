package com.nnt.fdcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthCredentialsController {

    @GetMapping("/sign-up")
    public String signUp() {
        return "/public/sign-up";
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "/public/sign-in";
    }
}

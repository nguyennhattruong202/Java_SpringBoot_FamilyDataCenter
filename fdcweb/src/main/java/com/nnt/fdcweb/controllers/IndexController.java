package com.nnt.fdcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
}

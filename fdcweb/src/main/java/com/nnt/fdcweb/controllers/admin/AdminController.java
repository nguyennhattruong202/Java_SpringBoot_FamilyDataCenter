package com.nnt.fdcweb.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "/admin/dashboard";
    }

    @GetMapping("/users")
    public String users() {
        return "/admin/user-list";
    }

    @GetMapping("/user/{id}")
    public String userDetail() {
        return "/admin/user-detail";
    }
}

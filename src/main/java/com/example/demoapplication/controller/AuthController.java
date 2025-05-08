package com.example.demoapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/index")
    public String indexPage() {
        return "index"; // загружает index.html из templates
    }
}

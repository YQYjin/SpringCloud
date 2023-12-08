package com.example.springcloud_provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {
    @GetMapping("/loginpage")
    public String loginControl(){

        return "employee/login-page";
    }
    @GetMapping("/adminloginpage")
    public String adminLoginControl(){
        return "admin/admin-login-page";
    }
}

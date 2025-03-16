package com.shashi.springsecurity.controller;

import com.shashi.springsecurity.entity.UserInfo;
import com.shashi.springsecurity.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/token")
    public String generateToken(@RequestBody UserInfo userInfo) {
        return jwtService.generateToken(userInfo.getName());
    }
}

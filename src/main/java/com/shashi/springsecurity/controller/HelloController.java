package com.shashi.springsecurity.controller;

// create a controller class HelloController with a method hello() which returns a string "Hello World"
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}

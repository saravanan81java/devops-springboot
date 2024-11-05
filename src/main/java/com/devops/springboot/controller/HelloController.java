package com.devops.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String message(){
        return "Welcome !!! jenkins CI/CD project sample";
    }
}

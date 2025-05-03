package com.ashmal.user_service.controller;

import com.ashmal.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {



    @GetMapping("/")
    public String hello() {
        return "Hello, User Service!";
    }

    @GetMapping("/{name}")
    public String hi(@PathVariable(value = "name") String name) {
        return "Hello " +name + "!";
    }

    @GetMapping("/ashmal")
    public String ashmal() {
        return "Hello Ashmal!";
    }
}
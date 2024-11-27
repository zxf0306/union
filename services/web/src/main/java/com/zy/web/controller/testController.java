package com.zy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/echo/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello World " + name;
    }
}

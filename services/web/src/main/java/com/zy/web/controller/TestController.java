package com.zy.web.controller;

import com.zy.web.dao.entity.UserDO;
import com.zy.web.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserMapper mapper;
    @GetMapping("/echo/{name}")
    public String sayHello(@PathVariable("name") String name) {
        UserDO userDO = mapper.selectById(1);
        return "Hello World " + name;
    }
}

package com.zy.web.controller;

import com.zy.distributeId.toolkit.SnowflakeIdUtil;
import com.zy.web.dao.entity.UserDO;
import com.zy.web.dao.mapper.UserMapper;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserMapper mapper;
//    @Autowired
//    private RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    @GetMapping("/echo/{name}")
    public String sayHello(@PathVariable("name") String name) {
//        userRegisterCachePenetrationBloomFilter.add("1");
//        boolean contains = userRegisterCachePenetrationBloomFilter.contains("1");
        return "Hello World " + SnowflakeIdUtil.nextId();
    }
}

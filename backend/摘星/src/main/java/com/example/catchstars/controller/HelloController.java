package com.example.catchstars.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试连接")
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value = "Hello", notes = "", httpMethod = "GET")
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}

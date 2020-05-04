package com.example.catchstars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.catchstars.dao")
public class CatchstarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchstarsApplication.class, args);
    }

}

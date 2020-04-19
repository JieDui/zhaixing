package com.example.catchstars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.catchstars")
public class CatchstarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchstarsApplication.class, args);
    }

}

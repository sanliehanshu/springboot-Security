package com.example.springsecurity_vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springsecurity_vue.mapper")
public class SpringsecurityVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityVueApplication.class, args);
    }

}

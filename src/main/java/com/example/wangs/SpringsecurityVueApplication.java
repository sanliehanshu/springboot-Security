package com.example.wangs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wangsheng
 */
@SpringBootApplication
@MapperScan("com.example.wangs.mapper")
public class SpringsecurityVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityVueApplication.class, args);
    }

}

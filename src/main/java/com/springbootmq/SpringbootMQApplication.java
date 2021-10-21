package com.springbootmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springbootalldemo.dao")
    public class SpringbootMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMQApplication.class, args);
        System.out.println("启动成功");
    }

}

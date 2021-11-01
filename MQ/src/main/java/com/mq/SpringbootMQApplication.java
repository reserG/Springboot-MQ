package com.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class SpringbootMQApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringbootMQApplication.class, args);
            System.out.println("启动成功");
        }

}

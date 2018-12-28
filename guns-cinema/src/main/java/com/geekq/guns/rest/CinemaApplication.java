package com.geekq.guns.rest;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.geekq.guns"})
@EnableDubboConfiguration
public class CinemaApplication {

    public static void main(String[] args) {

        SpringApplication.run(CinemaApplication.class, args);
    }
}

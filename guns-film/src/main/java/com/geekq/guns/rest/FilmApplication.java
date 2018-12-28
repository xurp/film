package com.geekq.guns.rest;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.geekq.guns"})
@EnableDubboConfiguration
public class FilmApplication {

    public static void main(String[] args) {

        SpringApplication.run(FilmApplication.class, args);
    }
}

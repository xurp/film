package com.geekq.guns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot方式启动类
 *
 * @author geekq
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class GunsAdminApplication {

    private final static Logger logger = LoggerFactory.getLogger(GunsAdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GunsAdminApplication.class, args);
        logger.info("GunsApplication is success!");
    }
}

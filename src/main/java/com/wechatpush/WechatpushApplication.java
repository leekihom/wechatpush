package com.wechatpush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WechatpushApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatpushApplication.class, args);
    }

}

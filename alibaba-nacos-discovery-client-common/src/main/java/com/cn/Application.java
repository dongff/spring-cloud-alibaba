package com.cn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2023-01-03 10:36
 * @modified By:
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {


    }

}

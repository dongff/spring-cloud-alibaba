package com.cn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dongff
 * @description: @SpringBootApplication定义是个Spring Boot应用；还定义了一个Controller，其中通过@Value注解，注入了key为didispace.title的配置（默认为空字符串），这个配置会通过/test接口返回，后续我们会通过这个接口来验证Nacos中配置的加载。另外，这里还有一个比较重要的注解@RefreshScope，主要用来让这个类下的配置内容支持动态刷新，也就是当我们的应用启动之后，修改了Nacos中的配置内容之后，这里也会马上生效。
 * @date: Created in 2022-12-19 14:52
 * @modified By:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Slf4j
    @RestController
    @RefreshScope
    static class TestController {

        @Value("${didispace.title:}")
        private String title;

        @GetMapping("/test")
        public String hello() {
            return title;
        }

    }

}

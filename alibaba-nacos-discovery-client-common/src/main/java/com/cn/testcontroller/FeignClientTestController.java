package com.cn.testcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dongff
 * @description: 这里主要先通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能；然后又创建一个Feign的客户端接口定义。使用@FeignClient注解来指定这个接口所要调用的服务名称，接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口，比如下面就是绑定alibaba-nacos-discovery-server服务的/hello接口的例子。最后，在Controller中，注入了Client接口的实现，并调用hello方法来触发对服务提供方的调用。
 * @date: Created in 2023-02-24 10:35
 * @modified By:
 */
@RestController
@Slf4j
public class FeignClientTestController {

    @Autowired
    Client client;

    @GetMapping("/test")
    public String test() {
        String result = client.hello("didi");
        return "Return : " + result;
    }


    @FeignClient("alibaba-nacos-discovery-server")
    interface Client {

        @GetMapping("/hello")
        String hello(@RequestParam(name = "name") String name);

    }
}

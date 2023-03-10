package com.cn.testcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2023-02-24 10:24
 * @modified By:
 */
@Slf4j
@RestController
public class RestTemplateTestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/RestTemplateTest")
    public String test() {
        String result = restTemplate.getForObject("http://alibaba-nacos-discovery-server/hello?name=didi", String.class);
        return "Return : " + result;
    }


    /**
     * 定义RestTemplate的时候，增加了@LoadBalanced注解，
     * 而在真正调用服务接口的时候，原来host部分是通过手工拼接ip和端口的，直接采用服务名的时候来写请求路径即可。
     * 在真正调用的时候，Spring Cloud会将请求拦截下来，
     * 然后通过负载均衡器选出节点，并替换服务名部分为具体的ip和端口，
     * 从而实现基于服务名的负载均衡调用。
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

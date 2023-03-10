package com.cn.testcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2023-02-24 10:30
 * @modified By:
 */
@Slf4j
@RestController
public class WebClientTestController {


    //@Autowired
    //private WebClient.Builder webClientBuilder;
    //
    //@GetMapping("/test")
    //public Mono<String> test() {
    //    Mono<String> result = webClientBuilder.build()
    //            .get()
    //            .uri("http://alibaba-nacos-discovery-server/hello?name=didi")
    //            .retrieve()
    //            .bodyToMono(String.class);
    //    return result;
    //}
    //
    //
    //@Bean
    //@LoadBalanced
    //public WebClient.Builder loadBalancedWebClientBuilder() {
    //    return WebClient.builder();
    //}
}

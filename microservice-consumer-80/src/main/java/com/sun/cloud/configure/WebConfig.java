package com.sun.cloud.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 18:43
 */
@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced // 启用Ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }*/
}

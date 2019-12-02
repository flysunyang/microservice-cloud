package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaoyang
 * @description 相关注解解释：
 * @EnableEurekaClient：该服务是Eureka客户端
 * @EnableDiscoveryClient：可以发现Eureka服务，可以自动注入DiscoveryClient
 * @EnableCircuitBreaker：启用Hystrix熔断器
 * @create 2019-12-01 17:31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

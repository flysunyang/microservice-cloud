package com.sun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhaoyang
 * @description Zuul路由网关服务需要注册到Eureka中，通过Eureka来访问各个微服务
 * zuul: B/S结构
 * @create 2019-12-02 17:55
 */
@SpringBootApplication
// @EnableEurekaClient
@EnableZuulProxy
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

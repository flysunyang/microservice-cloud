package com.sun.cloud.controller;

import com.sun.cloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 17:40
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    /**
     * 配置微服务名称（Spring Application Name），注意：需要添加上http://
     */
    private static final String REST_URL_PREFIX = "http://DEPT-PROVIDER";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}

package com.sun.cloud.controller;

import com.sun.cloud.pojo.Dept;
import com.sun.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 17:29
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services.toString());
        List<ServiceInstance> instances = discoveryClient.getInstances("DEPT-PROVIDER");
        for (ServiceInstance instance: instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }
        return discoveryClient;
    }
}

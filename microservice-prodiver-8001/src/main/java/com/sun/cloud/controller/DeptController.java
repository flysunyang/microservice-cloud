package com.sun.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.cloud.pojo.Dept;
import com.sun.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 当方法出现异常的时候，会走熔断器中设置的fallbackMethod
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixFallBack")
    public Dept get(@PathVariable("id") Integer id) {
        Dept dept = deptService.getById(id);
        if(dept == null) {
            throw new RuntimeException("该ID不存在");
        }
        return dept;
    }

    /**
     * 服务熔断，服务提供者端调用，当5秒内20次调用失败，
     * 就会启用熔断机制
     * @param id
     * @return
     */
    public Dept hystrixFallBack(@PathVariable("id") Integer id) {
        Dept dept = new Dept();
        dept.setId(id);
        dept.setDeptName("该ID在数据库不存在");
        dept.setDbSource("该ID在数据库内不存在");
        return dept;
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

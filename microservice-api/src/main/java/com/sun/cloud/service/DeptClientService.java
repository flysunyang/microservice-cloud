package com.sun.cloud.service;

import com.sun.cloud.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhaoyang
 * @description @FeignClient：feign注解，value属性是微服务名称DEPT-PROVIDER，fallbackFactory属性是服务降级方式
 * feign面向接口编程，内部包含了ribbon
 * @create 2019-12-02 12:58
 */
@FeignClient(value = "DEPT-PROVIDER", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    /**
     * 服务提供者provider的url路径
     * @return
     */
    @GetMapping("/dept/list")
    public List<Dept> list();

    /**
     * 根据ID查找Dept
     * @param id
     * @return
     */
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id);
}

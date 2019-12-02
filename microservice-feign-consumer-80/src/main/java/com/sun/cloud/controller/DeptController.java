package com.sun.cloud.controller;

import com.sun.cloud.pojo.Dept;
import com.sun.cloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-02 13:11
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    @Autowired
    DeptClientService deptClientService;

    @RequestMapping("/list")
    public List<Dept> list() {
        return deptClientService.list();
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptClientService.get(id);
    }
}

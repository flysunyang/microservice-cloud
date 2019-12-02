package com.sun.cloud.controller;

import com.sun.cloud.pojo.Dept;
import com.sun.cloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-02 13:11
 */
@RestController
@RequestMapping("/consumer")
public class DeptController {

    @Autowired
    DeptClientService deptClientService;

    @RequestMapping("/dept/list")
    public List<Dept> list() {
        return deptClientService.list();
    }
}

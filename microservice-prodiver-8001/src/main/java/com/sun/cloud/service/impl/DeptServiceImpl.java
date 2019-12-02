package com.sun.cloud.service.impl;

import com.sun.cloud.mapper.DeptMapper;
import com.sun.cloud.pojo.Dept;
import com.sun.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 17:28
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.selectById(id);
    }
}

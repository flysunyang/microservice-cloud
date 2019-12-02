package com.sun.cloud.service;

import com.sun.cloud.pojo.Dept;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 17:27
 */
public interface DeptService {

    /**
     * 查询所有的Dept数据
     * @return
     */
    List<Dept> list();

    /**
     * 根据ID查找Dept
     * @param id
     * @return
     */
    Dept getById(Integer id);
}

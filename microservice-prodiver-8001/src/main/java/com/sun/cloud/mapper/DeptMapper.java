package com.sun.cloud.mapper;

import com.sun.cloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 17:17
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询Dept表所有数据
     * @return
     */
    List<Dept> findAll();

    /**
     * 根据ID查找Dept
     * @param id
     * @return
     */
    Dept selectById(Integer id);
}

package com.sun.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoyang
 * @description
 * @create 2019-12-01 16:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    
    private Integer id;

    private String DeptName;
    
    private String dbSource;

}

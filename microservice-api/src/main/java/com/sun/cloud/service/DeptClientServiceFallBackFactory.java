package com.sun.cloud.service;

import com.sun.cloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaoyang
 * @description 当某个服务不够用的时候，需要将别的服务停掉去支持某个服务，
 * 但是不想用户请求出现异常或没有数据，给出友好性提示，所以使用服务降级，
 * 将服务在消费端进行降级处理
 * @create 2019-12-02 14:28
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Dept get(Integer id) {
                Dept dept = new Dept();
                dept.setId(id);
                dept.setDbSource("当前服务正忙，请稍后重试");
                dept.setDeptName("当前服务正忙，请稍后重试");
                return dept;
            }
        };
    }
}

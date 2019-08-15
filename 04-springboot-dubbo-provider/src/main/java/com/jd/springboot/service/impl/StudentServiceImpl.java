package com.jd.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jd.springboot.mapper.StudentMapper;
import com.jd.springboot.model.Student;
import com.jd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yangfei100
 * @Date: 2019/8/13
 * @Description:
 */
@Service(version = "1.0.0", timeout = 10000, interfaceClass = StudentService.class)    //dubbo的service注解
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String sayHi(String name) {
        return "Hi, SpringBoot : " + name;
    }

    @Override
    public Student getStudent(int id) {
        //查询数据库
        return studentMapper.selectByPrimaryKey(id);
    }
}

package com.jd.springboot.service;

import com.jd.springboot.model.Student;

import java.util.List;

/**
 * @Author: yangfei100
 * @Date: 2019/8/12
 * @Description:
 */
public interface StudentService {

    List<Student> getAllStudent();

    Integer update();
}

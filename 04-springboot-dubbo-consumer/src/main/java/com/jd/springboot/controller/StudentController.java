package com.jd.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jd.springboot.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangfei100
 * @Date: 2019/8/14
 * @Description:
 */
@RestController
public class StudentController {

    @Reference(version = "1.0.0")
    private StudentService studentService;

    @GetMapping("/boot/student/{id}")
    public Object getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/boot/hi/{name}")
    public Object sayHi(@PathVariable("name") String name) {
        return studentService.sayHi(name);
    }
}

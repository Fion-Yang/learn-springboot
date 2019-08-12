package com.jd.springboot.controller;

import com.jd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yangfei100
 * @Date: 2019/8/12
 * @Description:
 */
@Controller
public class MybatisController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/boot/students")
    public @ResponseBody Object students() {
        return studentService.getAllStudent();
    }

    @GetMapping("/boot/update")
    public @ResponseBody Object update() {
        return studentService.update();
    }
}

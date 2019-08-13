package com.jd.springboot.controller;

import com.jd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @GetMapping("/boot/multi")
    public @ResponseBody Object testMultiThread()
    {
        //多线程测试查询缓存穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(25);

        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    studentService.getAllStudent();
                }
            });
        }
        return studentService.getAllStudent();
    }
}

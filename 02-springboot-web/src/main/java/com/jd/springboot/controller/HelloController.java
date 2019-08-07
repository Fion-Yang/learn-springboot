package com.jd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yangfei100
 * @Date: 2019/8/7
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping("/boot/hello")
    public @ResponseBody String hello() {
        return "Hello Spring Boot";
    }
}

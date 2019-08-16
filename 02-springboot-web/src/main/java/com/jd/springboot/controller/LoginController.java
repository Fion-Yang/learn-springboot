package com.jd.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangfei100
 * @Date: 2019/8/16
 * @Description:
 */
@RestController
public class LoginController {

    @GetMapping("/boot/login/{name}")
    public String login(@PathVariable("name") String name) {
        //System.out.println("Welcome to My Home, " + name);
        return "Welcome to My Home, " + name;
    }

    @GetMapping("/boot/login/vip/{name}")
    public String vipLogin(@PathVariable("name") String name) {
        return "Welcome to Your Home, " + name;
    }
}

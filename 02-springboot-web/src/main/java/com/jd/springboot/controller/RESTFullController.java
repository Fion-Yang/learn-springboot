package com.jd.springboot.controller;

import com.jd.springboot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangfei100
 * @Date: 2019/8/12
 * @Description:
 */
@RestController
public class RESTFullController {

    //http://localhost:8088/fion/boot/user/fion/1234/26
    @GetMapping("/boot/user/{username}/{password}/{age}")
    public User user(@PathVariable String username, @PathVariable String password, @PathVariable Integer age) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        return user;
    }
}

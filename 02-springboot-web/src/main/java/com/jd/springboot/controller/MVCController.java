package com.jd.springboot.controller;

import com.jd.springboot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MVCController {

    @RequestMapping("/boot/user")
    public User getUser() {
        User user = new User();
        user.setAge(28);
        user.setUsername("fion");
        user.setPassword("cheryl");
        return user;
    }

    @GetMapping("/boot/getUser")
    public User getUserByGet() {
        User user = new User();
        user.setAge(28);
        user.setUsername("getfion");
        user.setPassword("cheryl");
        return user;
    }

    @PostMapping("/boot/postUser")
    public User getUserByPost() {
        User user = new User();
        user.setAge(28);
        user.setUsername("postfion");
        user.setPassword("cheryl");
        return user;
    }
}

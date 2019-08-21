package com.jd.springboot.controller;

import com.jd.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangfei100
 * @Date: 2019/8/21
 * @Description:
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/boot/index")
    public String index(Model model) {
        model.addAttribute("msg", "Spring Boot 集成 Thymeleaf. ");
        return "index";
    }

    @RequestMapping("/boot/user")
    public String user(Model model) {
        User user = new User();
        user.setId(1);
        user.setNick("Fion");
        user.setPhone("18768166688");
        user.setAddress("北京");
        model.addAttribute("user", user);
        model.addAttribute("hello", "helloworld");
        model.addAttribute("sex", 1);
        model.addAttribute("city", "2");
        return "user";
    }

    @RequestMapping("/boot/user/info/{id}")
    public @ResponseBody String info(@PathVariable("id") String id) {
        return id;
    }

    @RequestMapping("/boot/user/list")
    public String list(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "nick" + i, "phone" + i, "address" + i);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping("/boot/user/map")
    public String map(Model model) {
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "nick" + i, "phone" + i, "address" + i);
            map.put(i, user);
        }
        model.addAttribute("map", map);
        return "each";
    }

    @RequestMapping("/boot/user/array")
    public String array(Model model) {
        User[] userArray = new User[10];
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "nick" + i, "phone" + i, "address" + i);
            userArray[i] = user;
        }
        model.addAttribute("userArray", userArray);
        return "each";
    }
}

package com.jd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangfei100
 * @Date: 2019/8/20
 * @Description:
 */
@Controller
public class WarController {

    @RequestMapping("/boot/json")
    public @ResponseBody Object json() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "京东");
        map.put("address", "北京");
        return map;
    }

    @RequestMapping("/boot/jsp")
    public String jsp(Model model) {
        model.addAttribute("name", "京东");
        model.addAttribute("address", "北京");
        return "index";
    }
}

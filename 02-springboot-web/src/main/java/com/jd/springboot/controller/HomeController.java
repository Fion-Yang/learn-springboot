package com.jd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/boot/index")
    public String index(Model model) {
        model.addAttribute("msg", "fion");
        return "index";
    }
}

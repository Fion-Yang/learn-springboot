package com.jd.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jd.springboot.model.User;
import com.jd.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yangfei100
 * @Date: 2019/8/22
 * @Description:
 */
@Controller
public class UserController {

    @Reference
    private UserService userService;

    private static Integer PAGE_SIZE = 10;

    @RequestMapping("/user")
    public String index(@RequestParam(value = "curPage", required = false, defaultValue = "1") Integer curPage, Model model) {

        /**
         * 获得总数量
         */
        int total = userService.getTotal();

        /**
         * 获得页数
         */
        int pageCount = total / PAGE_SIZE;

        /**
         * 可能有余数，另行处理
         */
        if (total % PAGE_SIZE > 0) {
            pageCount++;
        }

        /**
         * 构造分页查询参数，并执行分页查询
         */
        Map<String, Object> searchMap = new ConcurrentHashMap<>(2);
        searchMap.put("startRow", (curPage - 1) * PAGE_SIZE);
        searchMap.put("pageSize", PAGE_SIZE);
        List<User> users = userService.getUserByPage(searchMap);

        /**
         * 推送展示数据
         */
        model.addAttribute("users", users);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("curPage", curPage);

        /**
         * 返回模板页面
         */
        return "index";
    }

    @RequestMapping("/user/modify")
    public String modify() {
        return "modify";
    }

    @RequestMapping("/user/delete")
    public void delete() {

    }
}

package com.jd.springboot.service.impl;

import com.jd.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: yangfei100
 * @Date: 2019/8/20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}

package com.jd.springboot.servcie.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jd.springboot.mapper.UserMapper;
import com.jd.springboot.model.User;
import com.jd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: yangfei100
 * @Date: 2019/8/22
 * @Description:
 */
@Component  //spring的注解
@Service  //dubbo的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByPage(Map<String, Object> searchMap) {
        return userMapper.selectUserByPage(searchMap);
    }

    @Override
    public Integer getTotal() {
        return userMapper.selectTotal();
    }
}

package com.jd.springboot.service;

import com.jd.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    List<User> getUserByPage(Map<String, Object> searchMap);

    /**
     * 查询数据总数
     * @return
     */
    Integer getTotal();

}

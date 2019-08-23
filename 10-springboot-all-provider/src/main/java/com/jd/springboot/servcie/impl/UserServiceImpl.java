package com.jd.springboot.servcie.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jd.springboot.mapper.UserMapper;
import com.jd.springboot.model.User;
import com.jd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    @Autowired
    private RedisTemplate<Object, Object> template;

    @Override
    public List<User> getUserByPage(Map<String, Object> searchMap) {
        return userMapper.selectUserByPage(searchMap);
    }

    @Override
    public Integer getTotal() {
        /**
         * 获取缓存
         */
        Integer total = (Integer) template.opsForValue().get("total");
        if (null == total) {
            /**
             * 家同步锁
             */
            synchronized (this) {
                total = (Integer) template.opsForValue().get("total");
                /**
                 * 双重校验，防止缓存穿透
                 */
                if (null == total) {
                    /**
                     * 查库
                     */
                    total = userMapper.selectTotal();
                    template.setKeySerializer(new StringRedisSerializer());
                    template.opsForValue().set("total", total);
                    System.out.println("查数据库，total: " + total);
                }
            }
        }
        return total;
    }

    @Override
    public Integer addUser(User user) {
        int add = userMapper.insert(user);
        if (add > 0) {
            template.delete("total");
        }
        return add;
    }

    @Override
    public Integer modifyUser(User user) {
        int modify = userMapper.updateByPrimaryKeySelective(user);
        return modify;
    }

    @Override
    public Integer deleteUser(Integer id) {
        int delete = userMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            template.delete("total");
        }
        return delete;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

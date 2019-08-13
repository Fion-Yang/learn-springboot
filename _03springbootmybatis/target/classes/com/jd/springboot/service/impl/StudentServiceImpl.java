package com.jd.springboot.service.impl;

import com.jd.springboot.mapper.StudentMapper;
import com.jd.springboot.model.Student;
import com.jd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yangfei100
 * @Date: 2019/8/12
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<Student> getAllStudent() {
        //字符串序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发情况下，此处有问题，缓存穿透
        //查询缓存
        List<Student> students = (List<Student>) redisTemplate.opsForValue().get("students");

        //双重检测锁，解决缓存穿透
        if (null == students) {
            synchronized (this) {
                students = (List<Student>) redisTemplate.opsForValue().get("students");

                if (null == students) {
                    //查数据库
                    students = studentMapper.selectAllStudent();
                    System.out.println("没缓存，需查数据库");

                    //将结果放进缓存
                    redisTemplate.opsForValue().set("students", students);
                } else {
                    System.out.println("有缓存，查询缓存");
                }
            }
        } else {
            System.out.println("有缓存，查询缓存");
        }

        return students;
    }

    @Transactional
    @Override
    public Integer update() {
        Student student = new Student();
        student.setId(1);
        student.setName("Fion");
        student.setAge(26);
        Integer update = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println("更新结果：" + update);

        //创造异常场景
        int a = 10 / 0;

        return update;
    }
}

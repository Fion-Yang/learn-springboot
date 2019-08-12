package com.jd.springboot.service.impl;

import com.jd.springboot.mapper.StudentMapper;
import com.jd.springboot.model.Student;
import com.jd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.selectAllStudent();
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

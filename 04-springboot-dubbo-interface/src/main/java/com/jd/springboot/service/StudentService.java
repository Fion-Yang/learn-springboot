package com.jd.springboot.service;

import com.jd.springboot.model.Student;

public interface StudentService {

    String sayHi(String name);

    Student getStudent(int id);
}

package com.jd.springboot.service;

import com.jd.springboot.model.StudentEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface StudentEntityService {

    List<StudentEntity> getAllStudentEntity();

    void exportStudentEntitys();

    void export1vsN();
}

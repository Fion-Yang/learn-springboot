package com.jd.springboot.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.google.common.collect.Lists;
import com.jd.springboot.mapper.StudentEntityMapper;
import com.jd.springboot.model.CourseEntity;
import com.jd.springboot.model.StudentEntity;
import com.jd.springboot.model.TeacherEntity;
import com.jd.springboot.service.StudentEntityService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * @Author: yangfei100
 * @Date: 2019/8/13
 * @Description:
 */
@Service
public class StudentEntityServiceImpl implements StudentEntityService {

    @Autowired
    private StudentEntityMapper studentEntityMapper;

    @Override
    public List<StudentEntity> getAllStudentEntity() {
        return studentEntityMapper.selectAll();
    }

    @Override
    public void exportStudentEntitys() {
        try {
            List<StudentEntity> studentEntities = getAllStudentEntity();
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("软件工程二班学生", "学生"),
                StudentEntity.class, studentEntities);

            FileOutputStream fos = new FileOutputStream("C:/Users/yangfei100/Desktop/student.xls");
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void export1vsN() {
        List<StudentEntity> studentEntities1 = getAllStudentEntity();
        List<StudentEntity> studentEntities2 = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(4 + i);
            studentEntity.setName("name" + i);
            studentEntity.setBirthday(new Date());
            studentEntity.setRegistrationdate(new Date());
            studentEntities2.add(studentEntity);
        }

        TeacherEntity teacherEntity1 = new TeacherEntity();
        teacherEntity1.setId("1");
        teacherEntity1.setName("杨老师");
        TeacherEntity teacherEntity2 = new TeacherEntity();
        teacherEntity2.setId("2");
        teacherEntity2.setName("陈老师");

        CourseEntity courseEntity1 = new CourseEntity();
        courseEntity1.setId("1");
        courseEntity1.setMathTeacher(teacherEntity1);
        courseEntity1.setName("语文");
        courseEntity1.setStudentEntities(studentEntities1);
        CourseEntity courseEntity2 = new CourseEntity();
        courseEntity2.setId("2");
        courseEntity2.setMathTeacher(teacherEntity2);
        courseEntity2.setName("数学");
        courseEntity2.setStudentEntities(studentEntities2);

        List<CourseEntity> list = Lists.newArrayList();
        list.add(courseEntity1);
        list.add(courseEntity2);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("课程表", "课程", "课程"), CourseEntity.class, list);

        try {
            FileOutputStream fos = new FileOutputStream("C:/Users/yangfei100/Desktop/course.xls");
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

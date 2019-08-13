package com.jd.springboot.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangfei100
 * @Date: 2019/8/13
 * @Description:
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ExcelTarget("courseEntity")
public class CourseEntity implements Serializable {

    private String id;

    @Excel(name = "课程名称", orderNum = "1", width = 25, needMerge = true)
    private String name;

    @ExcelEntity(id = "absent")
    private TeacherEntity mathTeacher;

    @ExcelCollection(name = "学生", orderNum = "4")
    private List<StudentEntity> studentEntities;
}

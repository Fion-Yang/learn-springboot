package com.jd.springboot.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: yangfei100
 * @Date: 2019/8/13
 * @Description:
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ExcelTarget("teacherEntity")
public class TeacherEntity implements Serializable {

    private String id;

    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", needMerge = true, isImportField = "true_major,true_absent")
    private String name;
}

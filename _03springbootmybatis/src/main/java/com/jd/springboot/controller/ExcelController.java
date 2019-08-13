package com.jd.springboot.controller;

import com.jd.springboot.service.StudentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yangfei100
 * @Date: 2019/8/13
 * @Description:
 */
@RestController
public class ExcelController {

    @Autowired
    private StudentEntityService studentEntityService;

    @GetMapping("/boot/export")
    public String export() {
        studentEntityService.exportStudentEntitys();
        return "COMPLATE";
    }

    @GetMapping("/boot/export/1*n")
    public String export1VsN() {
        studentEntityService.export1vsN();
        return "COMPLATE";
    }
}

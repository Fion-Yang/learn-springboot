package com.jd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.jd.springboot.servlet", "com.jd.springboot.filter"})
public class Application {

    public static void main(String[] args) {

        //启动springboot程序，启动spring容器，启动了内嵌的tomcat
        SpringApplication.run(Application.class, args);
    }

}

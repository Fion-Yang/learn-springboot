package com.jd.springboot;

import com.jd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    /*public static void main(String[] args) {
        //返回spring容器对象
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        System.out.println(userService.sayHi("Fion"));
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.sayHi("Cheryl"));
    }
}

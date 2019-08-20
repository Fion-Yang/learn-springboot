package com.jd.springboot.config;

import com.jd.springboot.servlet.HeServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yangfei100
 * @Date: 2019/8/20
 * @Description:
 */
@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean heServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HeServlet(), "/heServlet");
        return registrationBean;
    }
}

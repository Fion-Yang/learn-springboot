package com.jd.springboot.config;

import com.jd.springboot.filter.HeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @Author: yangfei100
 * @Date: 2019/8/20
 * @Description:
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean heFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HeFilter());
        registrationBean.addUrlPatterns("/heServlet/*");
        return registrationBean;
    }

    /**
     * 解决乱码问题，等价于web.xml中配置CharacterEncodingFilter
     * @return
     */
    /*@Bean
    public FilterRegistrationBean encodeFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setForceEncoding(true);
        encodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(encodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }*/
}

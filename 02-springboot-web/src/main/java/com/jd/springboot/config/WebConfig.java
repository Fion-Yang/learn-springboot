package com.jd.springboot.config;

import com.jd.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: yangfei100
 * @Date: 2019/8/16
 * @Description:
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 需要拦截的路径
         */
        String[] addPathPatterns = {
                "/boot/login/**"
        };

        /**
         * 不需要拦截的路径
         */
        String[] excludePathPatterns = {
                "/boot/login/vip/**"
        };

        /**
         * 注册登录拦截器
         */
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns);

        /*InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        interceptorRegistration.addPathPatterns();
        interceptorRegistration.excludePathPatterns();*/
    }
}

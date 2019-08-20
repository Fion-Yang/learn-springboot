package com.jd.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: yangfei100
 * @Date: 2019/8/20
 * @Description:
 */
public class HeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("您已经入hefilter过滤器，您的请求正常，请继续...");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

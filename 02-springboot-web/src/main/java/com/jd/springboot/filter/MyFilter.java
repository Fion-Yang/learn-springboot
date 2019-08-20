package com.jd.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: yangfei100
 * @Date: 2019/8/20
 * @Description:
 */
@WebFilter(urlPatterns = "/myServlet/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("您已经入myfilter过滤器，您的请求正常，请继续...");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

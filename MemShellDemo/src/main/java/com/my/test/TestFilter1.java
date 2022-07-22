package com.my.test;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter1 the second初始化");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter过滤");
        //放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁");

    }
}
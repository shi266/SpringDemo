package com.example.springdemo.com.util;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter  初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter  执行");
        request.getRequestDispatcher("");
        System.out.println();
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("Filter  销毁");
    }
}

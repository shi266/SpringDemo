package com.example.springdemo.com.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class Interceptor implements HandlerInterceptor {


    @Override
    public boolean  preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user = request.getSession().getAttribute("admin");
        Object count = request.getSession().getAttribute("count");
//        System.out.println("拦截器拦截到的session中的用户"+user);
//        System.out.println("当前在线人数："+count);
//        if(user == null || user.equals("")){
//            request.getRequestDispatcher("/index").forward(request, response);
//        }

        return true;
    }
    @Override
    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                    ModelAndView modelAndView) throws Exception {

//        System.out.println("拦截器第二步");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 Exception ex) throws Exception {
//        System.out.println("拦截器第三步");
    }

}

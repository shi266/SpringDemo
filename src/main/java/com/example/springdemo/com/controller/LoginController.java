package com.example.springdemo.com.controller;


import com.example.springdemo.com.entity.TestDouble;
import com.example.springdemo.com.entity.User;
import com.example.springdemo.com.service.LoginService;
import com.example.springdemo.com.util.ReturnJSON;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        System.out.println("进入后台");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("获取用户名与密码 \r "+username+"\t"+password);
        List<User> list= service.CheckLogin(username,password);
        if(0 != list.size() ){
            System.out.println("登录成功");
            List<User> list1 = service.selectall();
            Gson gson = new Gson();
            HttpSession session = request.getSession();
            session.setAttribute(username,"admin session 取值");
            session.setMaxInactiveInterval(20);//session过期时间20s

            if(cookies != null && cookies.length > 0){
                for (Cookie cookie : cookies){
                    return cookie.getName() + "&" + cookie.getValue()+"@\n";
                }
            }

            String str  = "{\"success\":\"true\",\"rowCount\":100,\"data\":"+gson.toJson(list1)+"}";
            System.out.println(str);

            String data = "{\"goodList\":\"true\""+gson.toJson(list1)+" }";
            return gson.toJson(request.getSession().getAttribute("username")+"登录成功");
        }else {
            System.out.println("登陆失败");
            return "fail";
        }
    }
    @GetMapping("/checktest")
    public ReturnJSON treew(User user) {
        ReturnJSON returnJSON = new ReturnJSON();

        System.out.println("准备进入测试页面");

        returnJSON.setSuccess(true);
            List<User> list1 = service.CheckLogin(user.getUsername(),user.getPassword());
            returnJSON.setData(list1);
            System.out.println("转换json后的数据"+returnJSON);
            return returnJSON;



    }

    @GetMapping("testdoublefee")
    public void addtest(TestDouble testDouble){
    String a = "5.29";
        testDouble.setId(1002);
        testDouble.setFee(Double.parseDouble(a));
        int i = service.addTest(testDouble);
        System.out.println(i);


    }
}

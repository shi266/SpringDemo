package com.example.springdemo.com.loginCrontroller;


import com.example.springdemo.com.entity.User;
import com.example.springdemo.com.service.LoginService;
import com.example.springdemo.com.util.ReturnJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

public class CheckLoginController {

    @Autowired
    LoginService service;
    @RequestMapping("checkLogin")
    public String checkLogin(String username, String password, ReturnJSON returnJSON, HttpSession session){
        System.out.println("检查登录");
        System.out.println("获取到的密码："+password);
        List<User> list=service.CheckLogin(username,password,session);
        System.out.println("session:"+session.getAttribute("user"));
        System.out.println("查询的用户："+list);
        if(0 != list.size()){
                return "YLDemo/userList.html";
        }else {
            returnJSON.setSuccess(false);
            returnJSON.setData("fail");
        }
        return "login.html";
    }
    @ResponseBody
    @RequestMapping("checkLoginTest")
    public ReturnJSON checkLoginTest(ReturnJSON returnJSON){
        List<User> list = new ArrayList<>();
        User u = new User();
        for (int i = 0; i < 5; i++) {
            u.setUsername("张三"+(i+1));
            u.setPassword("pwd"+(i+1));
            list.add(u);
        }
        returnJSON.setSuccess(true);
        returnJSON.setData(list);

        return returnJSON;
    }
}

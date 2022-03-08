package com.example.springdemo.com.service;

import com.example.springdemo.com.entity.TestDouble;
import com.example.springdemo.com.entity.User;

import java.util.List;

public interface LoginService {

    //查询登录
    List<User> CheckLogin(String username, String password);
    List<User> selectall();
    int addTest(TestDouble testDouble);
}

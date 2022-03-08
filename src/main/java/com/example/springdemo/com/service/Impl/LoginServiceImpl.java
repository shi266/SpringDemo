package com.example.springdemo.com.service.Impl;

import com.example.springdemo.com.entity.TestDouble;
import com.example.springdemo.com.entity.User;
import com.example.springdemo.com.mapper.LoginMapper;
import com.example.springdemo.com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper mapper;
    @Override
    public List<User> CheckLogin(String username, String password) {
        return mapper.CheckLogin(username, password);
    }

    @Override
    public List<User> selectall() {
        return mapper.selectall();
    }

    @Override
    public int addTest(TestDouble testDouble) {
        int i = mapper.addTest(testDouble);
        return i;
    }
}

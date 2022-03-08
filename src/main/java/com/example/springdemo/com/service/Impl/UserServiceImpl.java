package com.example.springdemo.com.service.Impl;

import com.example.springdemo.com.entity.User;
import com.example.springdemo.com.mapper.LoginMapper;
import com.example.springdemo.com.mapper.UserMapper;
import com.example.springdemo.com.service.LoginService;
import com.example.springdemo.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public List<User> getUsers() {
        return mapper.getUsers();
    }
}
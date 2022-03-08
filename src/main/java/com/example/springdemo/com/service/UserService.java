package com.example.springdemo.com.service;

import com.example.springdemo.com.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> getUsers();
}

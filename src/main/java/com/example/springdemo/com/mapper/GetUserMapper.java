package com.example.springdemo.com.mapper;

import com.example.springdemo.com.entity.User;
import com.example.springdemo.com.entity.UserName;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface GetUserMapper {


    List<User> getAll(User user);
    List<User> getExcel(User user);
    int getRows(User user);
    List<UserName> getUserName();
    List<User> getByUserName(String username);
}

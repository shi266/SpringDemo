package com.example.springdemo.com.mapper;

import com.example.springdemo.com.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    //获取所有数据
    List<User> getUsers();
    //获取数据条数
//    int getRows(UserPage page);
    //添加数据
    boolean addUSer(User user);
    //修改数据
    boolean updateUser(User user);
    //删除数据
    boolean deleteUser(int id);

}

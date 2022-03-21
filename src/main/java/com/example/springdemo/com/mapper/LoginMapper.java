package com.example.springdemo.com.mapper;

import com.example.springdemo.com.entity.TestDouble;
import com.example.springdemo.com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpSession;
import java.util.List;

@Mapper
public interface LoginMapper {

    //查询登录
    List<User> CheckLogin(String username, String password);
    List<User> selectall();
    User valiteLogin(User user);
    User getById(Integer id);
    @Select("select * from user where id=#{id}")
    User selectById(Integer id);
    boolean updateById(User user);
    int addTest(TestDouble testDouble);
}

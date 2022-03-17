package com.example.springdemo.com.controller;


import com.example.springdemo.com.entity.TUser;
import com.example.springdemo.com.entity.User;
import com.example.springdemo.com.mapper.GetUserMapper;
import com.example.springdemo.com.mapper.LoginMapper;
import com.example.springdemo.com.util.ReturnJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TUserCOntroller {

    @Resource
    private GetUserMapper mapper;


    @GetMapping("/getTuser")
    @ResponseBody
    public ReturnJSON testinfo(User user ,ReturnJSON returnJSON){
        System.out.println("查询Tuser");
        List<TUser> list = mapper.getTUser();
        returnJSON.setSuccess(true);
        returnJSON.setData(list);
        return returnJSON;
    }
}

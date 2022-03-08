package com.example.springdemo.com.entity;

import com.example.springdemo.com.Page.BasePage;
import org.springframework.stereotype.Component;

@Component
public class UserName extends BasePage {

    private String username;

    @Override
    public String toString() {
        return "UserName{" +
                "username='" + username + '\'' +
                           '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

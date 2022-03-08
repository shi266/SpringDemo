package com.example.springdemo.com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

//@Component
public class MyServletRequestListener implements ServletRequestListener {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }
}

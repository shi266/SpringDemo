package com.example.springdemo.com.service;


import com.example.springdemo.com.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Product {
   private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Resource
   private ApplicationContext app;

   public Person lisTo(){
      Person person = new Person();
      person.setUsername("我是触发器");
//      app.publishEvent(new ListenTo(this, person));
      System.out.println("触发器被触发");
      return person;
   }




}

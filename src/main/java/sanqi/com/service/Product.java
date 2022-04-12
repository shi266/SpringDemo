package sanqi.com.service;


import sanqi.com.entity.Person;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

//@Service
public class Product {

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

package com.example.springdemo.com.test.redis;

import com.example.springdemo.com.entity.User;
import com.google.gson.Gson;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

public class Demo {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public static void testRedis(){
//        Template stringTemplate = new Template();
        StringRedisTemplate stringTemplate = new StringRedisTemplate();
        Gson gson = new Gson();
        User user = new User();
        user.setUsername("Redis");
        user.setPassword("123456");
        user.setAddress("Springboot");
        ValueOperations<String, String> valueTemplate = stringTemplate.opsForValue();


        valueTemplate.set("StringKey1", "hello spring boot redis, String Redis");
        String value = valueTemplate.get("StringKey1");
        System.out.println(value);

        valueTemplate.set("StringKey2", gson.toJson(user));
        User stringUser = gson.fromJson(valueTemplate.get("StringKey2"), User.class);
        System.out.println(stringUser);
    }

    public static void main(String[] args) {
        testRedis();
    }
}

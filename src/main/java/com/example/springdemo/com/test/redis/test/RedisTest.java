package com.example.springdemo.com.test.redis.test;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        System.out.println("连接成功");
        System.out.println("Jedis服务状态："+jedis.ping());

        Set<String> key = jedis.keys("*");
        Iterator iterator = key.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

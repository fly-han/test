package com.han.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * test redis by java
 * Created by hanfei3 on 2017/4/7.
 */
public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.87.12.60", 6379);
        jedis.auth("rootHan");
        jedis.set("name","testHan");
        String name = jedis.get("name");
        System.out.println(name);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
//        jedis.lpush("nameList","name1");
//        jedis.lpush("nameList","name2");
//        List<String> nameList = jedis.lrange("nameList", 0, 2);
//        jedis.expire("nameList",100);
//        System.out.println(nameList);
    }
}

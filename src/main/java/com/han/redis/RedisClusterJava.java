package com.han.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * redis cluster test
 * Created by hanfei3 on 2017/4/13.
 */
public class RedisClusterJava {
    private static final int CONNECTION_TIMEOUT = 10000;//连接Redis Server超时时间
    private static final int SO_TIMEOUT = 3000;//等待Response超时时间
    public static void main(String[] args) {
        JedisPoolConfig pollConfig = new JedisPoolConfig();
        pollConfig.setMaxWaitMillis(-1);//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        pollConfig.setMaxTotal(10);//最大连接数 ，默认8
        pollConfig.setMaxIdle(100);//最大空闲连接数 ，默认8
        pollConfig.setMinIdle(8);//最小空闲连接数, 默认0
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("10.87.12.60", 6379));
        nodes.add(new HostAndPort("10.87.12.60", 6380));
        nodes.add(new HostAndPort("10.87.12.60", 6381));
        nodes.add(new HostAndPort("10.87.15.140", 6382));
        nodes.add(new HostAndPort("10.87.15.140", 6383));
        nodes.add(new HostAndPort("10.87.15.140", 6384));
        JedisCluster jedisCluster = new JedisCluster(nodes, CONNECTION_TIMEOUT, SO_TIMEOUT, 3, "rootHan", pollConfig);
        String name = jedisCluster.get("name");
        System.out.println(name);

        jedisCluster.set("cluster", "6个集群节点");

        System.out.println(jedisCluster.get("cluster"));

        System.out.println(jedisCluster.publish("channel1", "ss"));
    }


    @Before
    public void  before() {
        System.out.println("before");
    }

    @Test
    public void test() {
        System.out.println(111);
    }


}

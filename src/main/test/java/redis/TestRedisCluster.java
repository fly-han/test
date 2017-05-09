package redis;

import com.han.redis.JedisPubSubListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hanfei3 on 2017/4/13.
 */
public class TestRedisCluster{
    private static final int CONNECTION_TIMEOUT = 10000;//连接Redis Server超时时间
    private static final int SO_TIMEOUT = 3000;//等待Response超时时间

    private JedisCluster jedisCluster;
    @Before
    public void before() {
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
        jedisCluster = new JedisCluster(nodes, CONNECTION_TIMEOUT, SO_TIMEOUT, 3, "rootHan", pollConfig);
        System.out.println("before init jedisCluster finished!");
    }

    @Test
    public void testGetByKey() {
        System.out.println(jedisCluster.get("name"));
    }


    /**
     * 测试发布
     */
    @Test
    public void publish() {
        System.out.println(jedisCluster.publish("channel1", "ss"));
    }

    /**
     * 订阅
     */
    @Test
    public void subscription(){
        jedisCluster.subscribe(new JedisPubSubListener(), "channel1");
    }

    /**
     * 测试列表（队列）
     */
    @Test
    public void testRedisList(){
        String value = jedisCluster.lindex("list1", 0);
        System.out.println(value);
        List<String> list1 = jedisCluster.blpop(60, "list1");
        System.out.println(list1);
    }


    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

}

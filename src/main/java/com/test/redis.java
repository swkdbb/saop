package com.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redis {

    @Test
    public void test() {
        Jedis jedis = new Jedis("39.99.178.106", 6379);
        jedis.set("username", "张三");
        jedis.set("password", "123");

        System.out.println(jedis.get("username"));
        System.out.println(jedis.get("password"));
    }

    @Test
    public void test2() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "39.99.178.106", 6379);
        Jedis resource = jedisPool.getResource();
        resource.set("user", "jack");
        System.out.println(resource.get("user"));
    }

}

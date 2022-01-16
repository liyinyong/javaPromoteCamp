package com.example.eleventhweekhomework.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Component
public class RedisCountUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public long increase(String key) {
        return stringRedisTemplate.opsForValue().increment(key);
    }

    public long decrease(String key) {
        return stringRedisTemplate.opsForValue().decrement(key);
    }

    public long get(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value == null ? 0 : Long.valueOf(value);
    }
}

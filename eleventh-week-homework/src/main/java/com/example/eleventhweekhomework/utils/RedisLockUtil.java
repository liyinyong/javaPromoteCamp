package com.example.eleventhweekhomework.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisLockUtil {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 尝试获取分布式锁
     * 当前没有锁（key不存在），那么就进行加锁操作，并对锁设置个有效期，同时value表示加锁的客户端。2. 已有锁存在，不做任何操作
     *
     * @param lockKey    锁
     * @param requestId  请求标识。 分布式锁四个条件解铃还须系铃人，通过给value赋值为requestId，就知道这把锁是哪个请求加的，在解锁的时候就可以有依据。
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime, int waitTime) {
        boolean lock = false;
        try {
            if (waitTime <= 0) {
                lock = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, requestId, expireTime, TimeUnit.SECONDS);
            } else {
                for (int i = 0; i < waitTime; i++) {
                    lock = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, requestId, expireTime, TimeUnit.SECONDS);
                    if (lock) {
                        return lock;
                    }
                }
            }
        } catch (Exception e) {
            log.error("redis创建锁出现异常", e);
        } finally {

        }
        return lock;
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean releaseDistributedLock(String lockKey, String requestId) {
        boolean release = false;
        try {
            String val = stringRedisTemplate.opsForValue().get(lockKey);
            if (!StringUtils.isEmpty(release) && val.equals(requestId)) {
                release = stringRedisTemplate.delete(lockKey);
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("redis释放锁出现异常", e);
        } finally {
        }
        return release;
    }
}

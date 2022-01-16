package com.example.eleventhweekhomework;

import com.example.eleventhweekhomework.utils.RedisCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication(scanBasePackages ="com.example")
public class EleventhWeekHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EleventhWeekHomeworkApplication.class, args);
    }

    @Resource
    private RedisCountUtil redisCountUtil;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("increase:{}", redisCountUtil.increase("count"));
        log.info("decrease：{}", redisCountUtil.decrease("count"));
        log.info("get:{}", redisCountUtil.get("count"));

        stringRedisTemplate.convertAndSend("order","111111");
        stringRedisTemplate.convertAndSend("order","222222");

    }
}

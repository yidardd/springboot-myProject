package com.mr.web.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by stack on 2019/6/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BRoleControllerTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        for (int i = 0; i < 1000; i++) {
            stringRedisTemplate.opsForValue().set("token:"+ UUID.randomUUID().toString(),UUID.randomUUID().toString());
        }

    }

}
package com.mr.web.controller;

import com.mr.common.ResponseObject;
import com.mr.service.TestService;
import com.mr.web.annotation.MyPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by stack on 2019/6/9.
 */
@RestController
@RequestMapping("/redis")
@Slf4j
@Api(tags = "TestController", description = "测试controller")
public class TestRedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "redis--test")
    public ResponseObject test() {
        ResponseObject responseObject = new ResponseObject();
        redisTemplate.opsForValue().set("aaa","aaa");
        String aaa = redisTemplate.opsForValue().get("aaa");
        log.error(aaa);
        responseObject.success("ok");
        return responseObject;
    }

}

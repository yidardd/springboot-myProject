package com.mr.web.controller;

import com.mr.common.ResponseObject;
import com.mr.service.TestService;
import com.mr.web.annotation.MyPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@MyPermission(needRole = MyPermission.Role.A )
@Api(tags = "TestController", description = "测试controller")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @MyPermission(needRole = MyPermission.Role.B )
    @ApiOperation(value = "测试重载getUserId")
    public ResponseObject getUserId(HttpServletRequest request, Model model) {
        ResponseObject responseObject = new ResponseObject();
        String test = testService.test();
        log.error("aaa");
        log.info("aaa");
        responseObject.success("ok");
        return responseObject;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @MyPermission(needRole = MyPermission.Role.B )
    @ApiOperation(value = "测试重载getUserId2")
    public ResponseObject getUserId(HttpServletRequest request, Model model, @RequestParam("id") Integer id) {
        ResponseObject responseObject = new ResponseObject();
        String test = testService.test();
        log.error("aaa");
        log.info("aaa");
        responseObject.success("ok");
        return responseObject;
    }

}

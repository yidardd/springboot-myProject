package com.mr.web.controller;

import com.mr.common.ResponseObject;
import com.mr.service.TestService;
import com.mr.web.annotation.MyPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;

/**
 * Created by stack on 2019/6/9.
 */
@RestController
@Slf4j
@Api(tags = "TestReqParamController", description = "测试controller")
@Validated
public class TestReqParamController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/testReq1", method = RequestMethod.GET)
    @ApiOperation(value = "测试重载getUserId")
    public ResponseObject testReq1(Integer integer) {
        ResponseObject responseObject = new ResponseObject();
        System.out.println(integer);
        responseObject.success("ok");
        return responseObject;
    }

    @RequestMapping(value = "/testReq2", method = RequestMethod.GET)
    @ApiOperation(value = "测试重载getUserId2")
    public ResponseObject testReq2(@RequestParam("i") @NotEmpty String integer) {
        ResponseObject responseObject = new ResponseObject();
        System.out.println(integer);
        responseObject.success("ok");
        return responseObject;
    }

}

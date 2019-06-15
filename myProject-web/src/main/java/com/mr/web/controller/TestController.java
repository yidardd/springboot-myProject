package com.mr.web.controller;

import com.mr.common.ResponseObject;
import com.mr.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by stack on 2019/6/9.
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public ResponseObject getUserId(HttpServletRequest request, Model model) {
        ResponseObject responseObject = new ResponseObject();
        String test = testService.test();
        log.error("aaa");
        log.info("aaa");
        responseObject.success("ok");
        return responseObject;
    }

}

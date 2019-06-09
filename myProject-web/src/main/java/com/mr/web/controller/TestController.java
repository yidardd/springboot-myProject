package com.mr.web.controller;

import com.mr.common.ResponseObject;
import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public ResponseObject getUserId(HttpServletRequest request, Model model) {
        ResponseObject responseObject = new ResponseObject();
//        String test = testService.test();
        log.error("aaa");
        log.info("aaa");
        responseObject.success("ok");
        return responseObject;
    }

}

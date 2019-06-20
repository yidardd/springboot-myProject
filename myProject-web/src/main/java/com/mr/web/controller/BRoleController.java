package com.mr.web.controller;

import com.mr.common.ResponseObject;
import com.mr.web.annotation.MyPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by stack on 2019/6/19.
 */
@RestController
@Slf4j
@MyPermission(needRole = MyPermission.Role.A )
public class BRoleController {

    @RequestMapping(value = "/bCan", method = RequestMethod.GET)
//    @MyPermission(needRole = MyPermission.Role.B )
    public ResponseObject getUserId(HttpServletRequest request) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.success("ok");
        return responseObject;
    }

}

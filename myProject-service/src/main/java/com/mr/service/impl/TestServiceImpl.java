package com.mr.service.impl;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.mr.mapper.DwRoleMapper;
import com.mr.pojo.DwRole;
import com.mr.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by stack on 2019/6/15.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private DwRoleMapper dwRoleMapper;

    @Override
    public String test() {
        DwRole dwRole = dwRoleMapper.selectByPrimaryKey(1L);
        return JSON.toJSONString(dwRole);
    }
}

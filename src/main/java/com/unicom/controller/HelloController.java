package com.unicom.controller;

import com.alibaba.fastjson.JSON;
import com.unicom.dao.UserDao;
import com.unicom.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by linym on 2017/12/10.
 */

@EnableEurekaClient
@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "插入用户",notes = "插入用户")
    @RequestMapping(value="/hi",method= RequestMethod.GET)
    public String hello(User user){
        int i=userDao.insert(user);
        return Integer.toString(i);
    }

    @ApiOperation(value="查询用户",notes = "查询用户")
    @ApiImplicitParam(name = "username",value = "用户名称",required = true,dataType = "String")
    @RequestMapping(value="/query",method= RequestMethod.GET)
    public String getUser(String username) {
        User user=new User();
        user.setUserName(username);
        List<User> userList = userDao.list(user);
        return JSON.toJSONString(userList);
    }
}

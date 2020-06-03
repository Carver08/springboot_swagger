package com.ms.swagger.controller;

import com.ms.swagger.entity.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ms_miao
 * @createTime 2020-06-03 15:39
 */
@RestController
public class HelloController {

    @ApiOperation("返回一个json字符串")
    @PostMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("返回一个空user实例")
    @PostMapping("/user1")
    public User user1(){
        return new User();
    }

    @ApiOperation("返回一个完整的user实例")
    @PostMapping("/user2")
    public User user2(@ApiParam("用户编号")Integer id,
                     @ApiParam("用户名称")String username,
                     @ApiParam("用户密码")String password){
        return new User(id,username,password);
    }
}

package com.ms.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ms_miao
 * @createTime 2020-06-03 16:54
 */
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户编号")
    public Integer id;
    @ApiModelProperty("用户名称")
    public String username;
    @ApiModelProperty("用户密码")
    public String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}

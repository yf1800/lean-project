package com.mybatis.controller;

import com.mybatis.entity.User;
import com.mybatis.service.UserService;
import com.mybatis.util.execption.CustomException;
import com.mybatis.util.response.ResponseObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@AllArgsConstructor
@Api(value = "用户相关的接口")
public class UserController {

    private UserService userService;


    //新增 user 对象到数据库
    @PostMapping("/add")
    @ApiOperation(value = "新增用户")
    public ResponseObject makeAddUser(@RequestBody User user) {
        ResponseObject responseObject = null;
        try {
            log.info("incoming the object is :{}", user);
            userService.addUser(user);
            responseObject = responseObject.success();
        } catch (CustomException cu) {
            responseObject = responseObject.error(cu.getCode(), cu.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseObject;
    }


    //通过用户 id 获取用户信息
    @GetMapping("/{id}")
    @ApiOperation("通过用户的id获取用户")
    public ResponseObject makeGetUser( Integer id) {
        log.info("incomgint pzram id id : {}", id);
        ResponseObject responseObject = null;
        try {
            responseObject = responseObject.success(userService.getUserById(id));
        } catch (CustomException cu) {
            responseObject = responseObject.error(cu.getCode(), cu.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseObject(userService.getUserById(id));
    }


}

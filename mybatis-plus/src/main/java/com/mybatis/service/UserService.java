package com.mybatis.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.entity.User;

public interface UserService extends IService<User> {

    //新增 user 对象
    int addUser(User user);

    //通过 user 的编号获取 user 对象
    User getUserById(Integer id);

    //修改用户信息，通过用户的 id 修改
    int updateUser(User user);

}

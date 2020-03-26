package com.mybatis.service.Impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import com.mybatis.service.UserService;
import com.mybatis.util.enmu.RestCode;
import com.mybatis.util.execption.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    //新增用户信息
    @Override
    public int addUser(User user) {

        if (StrUtil.hasEmpty(user.getName())) {

            throw new CustomException(RestCode.incomingobjectIsNull.code, RestCode.incomingobjectIsNull.msg);

        }
        return this.baseMapper.insert(user);
    }


    //通过 user 的编号获取 user 对象
    @Override
    public User getUserById(Integer id) {

        if (id == null) {
            throw new CustomException(-1, "没有参数");
        }
        User user = this.baseMapper.selectById(id);
        if (ObjectUtil.isEmpty(user)) {
            throw new CustomException(RestCode.returnObjectIsNull.code, RestCode.returnObjectIsNull.msg);
        }
        return user;
    }

    //修改用户信息
    @Override
    public int updateUser(User user) {

        if (StrUtil.hasEmpty(user.getId().toString())) {


        }

        return 0;
    }


}

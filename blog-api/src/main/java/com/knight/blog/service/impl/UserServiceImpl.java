package com.knight.blog.service.impl;

import com.knight.blog.common.util.PasswordHelper;
import com.knight.blog.entity.User;
import com.knight.blog.mapper.UserMapper;
import com.knight.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    @Transactional
    public Long saveUser(User user) {
        PasswordHelper.encryptPassword(user);
        //设置头像编号为1-6
        int index = new Random().nextInt(6) + 1;
        String avatar = "/static/user/user_"+index+".png";
        user.setAdmin(false);
        user.setAvatar(avatar);
        return userMapper.saveUser(user);
    }
}

package com.knight.blog.mapper;

import com.knight.blog.entity.User;

public interface UserMapper {
    User getUserByAccount(String account);

    Long saveUser(User user);
}

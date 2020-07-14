package com.knight.blog.service;

import com.knight.blog.entity.User;

public interface UserService {
    User getUserByAccount(String account);

    Long saveUser(User user);
}

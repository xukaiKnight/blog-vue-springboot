package com.knight.blog.common.util;

import com.knight.blog.common.constant.Base;
import com.knight.blog.entity.User;
import org.apache.shiro.SecurityUtils;

public class UserUtils {
    public static User getCurrentUser()
    {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
        return user;
    }
}

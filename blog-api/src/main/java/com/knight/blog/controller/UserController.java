package com.knight.blog.controller;

import com.knight.blog.common.constant.ResultCode;
import com.knight.blog.common.result.Result;
import com.knight.blog.common.util.UserUtils;
import com.knight.blog.entity.User;
import com.knight.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/currentUser")
    public Result getCurrentUser()
    {
        Result r = new Result();
        User currentUser = UserUtils.getCurrentUser();

        r.setResultCode(ResultCode.SUCCESS);
        r.setData(currentUser);
        return r;
    }


}

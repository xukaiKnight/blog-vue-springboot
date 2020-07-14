package com.knight.blog.controller;

import com.knight.blog.common.result.Result;
import com.knight.blog.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    CategoryMapper mapper;

    @GetMapping
    public Result listCategorys()
    {
        return Result.success(mapper.getAllCategorys());
    }

}

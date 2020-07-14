package com.knight.blog.service.impl;

import com.knight.blog.entity.Category;
import com.knight.blog.mapper.CategoryMapper;
import com.knight.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper mapper;

    @Override
    public List<Category> getAllCategorys() {
        return mapper.getAllCategorys();
    }
}

package com.knight.blog.service.impl;

import com.knight.blog.entity.Tag;
import com.knight.blog.mapper.TagMapper;
import com.knight.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper mapper;

    @Override
    public List<Tag> getTagListByArticleId(int id) {
        return mapper.getTagListByArticleId(id);
    }

    @Override
    public List<Tag> getHotTagsByArticleUse(int limit) {

        return mapper.getHotTagsByArticleUse(limit);
    }

    @Override
    public List<Tag> getAllTags() {
        return mapper.getAllTags();
    }
}

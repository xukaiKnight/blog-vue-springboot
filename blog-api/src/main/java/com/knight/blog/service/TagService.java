package com.knight.blog.service;

import com.knight.blog.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTagListByArticleId(int id);

    List<Tag> getHotTagsByArticleUse(int limit);

    List<Tag> getAllTags();
}

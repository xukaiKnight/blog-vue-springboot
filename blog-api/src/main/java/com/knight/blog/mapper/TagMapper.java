package com.knight.blog.mapper;

import com.knight.blog.entity.Tag;

import java.util.List;

public interface TagMapper {
    List<Tag> getTagListByArticleId(int id);

    List<Tag> getHotTagsByArticleUse(int limit);

    List<Tag> getAllTags();

    void deleteArticleTagByArticleId(int articleId);

    void insertArticleTag(List<Tag> tagList, int articleId);
}

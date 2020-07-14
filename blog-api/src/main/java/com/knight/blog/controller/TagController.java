package com.knight.blog.controller;

import com.knight.blog.common.result.Result;
import com.knight.blog.entity.Tag;
import com.knight.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/hot")
    public Result getHotTagsByArticleUse()
    {
        int limit=6;
        List<Tag> tags = tagService.getHotTagsByArticleUse(limit);

        return Result.success(tags);
    }

    @GetMapping
    public Result getAllTags()
    {
        return Result.success(tagService.getAllTags());
    }
}

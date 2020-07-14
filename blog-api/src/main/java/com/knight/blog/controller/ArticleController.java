package com.knight.blog.controller;

import com.knight.blog.common.constant.ResultCode;
import com.knight.blog.common.result.Result;
import com.knight.blog.entity.Article;
import com.knight.blog.entity.Tag;
import com.knight.blog.mapper.ArticleMapper;
import com.knight.blog.service.ArticleService;
import com.knight.blog.service.TagService;
import com.knight.blog.vo.ArticleVo;
import com.knight.blog.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    TagService tagService;

    @GetMapping
    public Result listArticles(ArticleVo articleVo, PageVo pageVo)
    {
        List<Article> list = articleService.getArticles(articleVo,pageVo);
   //     List<Article> list = articleMapper.getAllArticles();

        return Result.success(list);
    }

    @GetMapping("/hot")
    public Result listArticles()
    {
        int limit=6;
        List<Article> list = articleService.getArticlesOrderByViewsAndLimit(limit);

        return Result.success(list);
    }

    @GetMapping("/listArchives")
    public Result listArchives()
    {
        List<ArticleVo> list = articleService.listArchives();
        return Result.success(list);
    }

    @GetMapping("/view/{id}")
    public Result getArticleAndAddViews(@PathVariable("id") Integer id)
    {
        Result r = new Result();
        if (id<0) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }

        Article article = articleService.getArticleAndAddViews(id);
        List<Tag> tagList = tagService.getTagListByArticleId(article.getId());
        article.setTagList(tagList);
        r.setResultCode(ResultCode.SUCCESS);
        r.setData(article);
        return r;
    }

    @GetMapping("/{id}")
    public Result getArticleById(@PathVariable("id") Integer id)
    {
        Result r = new Result();

        if (null == id) {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }

        Article article = articleService.getBaseArticleById(id);

        r.setResultCode(ResultCode.SUCCESS);
        r.setData(article);
        return r;
    }

    @PostMapping("/publish")
    @RequiresAuthentication
    public Result saveArticle(@RequestBody  Article article)
    {
        articleService.publishArticle(article);

        Result r = Result.success();
        r.simple().put("articleId",article.getId());
        return r;
    }
}

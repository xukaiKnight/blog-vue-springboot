package com.knight.blog.service;

import com.knight.blog.entity.Article;
import com.knight.blog.vo.ArticleVo;
import com.knight.blog.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    List<Article> getArticles(ArticleVo av,PageVo pv);

    List<Article> getArticlesOrderByViewsAndLimit(int limit);

    List<ArticleVo> listArchives();

    Article getArticleAndAddViews(int id);

    Article getBaseArticleById(int id);

    void publishArticle(Article article);

    void saveArticle(Article article);

    void updateArticle(Article article);
}

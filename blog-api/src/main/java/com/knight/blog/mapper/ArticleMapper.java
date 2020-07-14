package com.knight.blog.mapper;

import com.knight.blog.entity.Article;
import com.knight.blog.entity.ArticleBody;
import com.knight.blog.vo.ArticleVo;
import com.knight.blog.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    List<Article> getAllArticles();

    List<Article> getArticles(@Param("av") ArticleVo av,@Param("pv") PageVo pv);

    List<Article> getArticlesOrderByViewsAndLimit(int limit);

    List<ArticleVo> listArchives();

    Article getArticleAndAddViews(int id);

    Article getBaseArticleById(int id);

    void updateCount(int id, int count);

    void saveArticle(Article article);

    void updateArticle(Article article);

    Integer saveArticleBody(ArticleBody body);

    void updateArticleBody(ArticleBody body);
}

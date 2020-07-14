package com.knight.blog.service.impl;

import com.knight.blog.common.util.UserUtils;
import com.knight.blog.entity.Article;
import com.knight.blog.entity.User;
import com.knight.blog.mapper.ArticleMapper;
import com.knight.blog.mapper.TagMapper;
import com.knight.blog.service.ArticleService;
import com.knight.blog.vo.ArticleVo;
import com.knight.blog.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper mapper;

    @Autowired
    TagMapper tagMapper;
    @Override
    public List<Article> getAllArticles() {
        return mapper.getAllArticles();
    }

    @Override
    public List<Article> getArticles(ArticleVo av, PageVo pv) {
        return mapper.getArticles(av,pv);
    }

    @Override
    public List<Article> getArticlesOrderByViewsAndLimit(int limit) {
        return mapper.getArticlesOrderByViewsAndLimit(limit);
    }

    @Override
    public List<ArticleVo> listArchives() {
        return mapper.listArchives();
    }

    @Override
    public Article getArticleAndAddViews(int id) {
        return mapper.getArticleAndAddViews(id);
    }

    @Override
    public Article getBaseArticleById(int id) {
        return mapper.getBaseArticleById(id);
    }

    @Override
    @Transactional
    public void publishArticle(Article article) {
        if(null != article.getId()){
           updateArticle(article);
        }else{
            saveArticle(article);
        }
    }

    @Override
    @Transactional
    public void saveArticle(Article article) {
        User currentUser = UserUtils.getCurrentUser();

        if (null != currentUser) {
            article.setAuthor(currentUser);
        }
        article.setAuthorId(currentUser.getId());
        article.setCommentCounts(0);
        article.setViewCounts(1);
        article.setCreateDate(new Date());
        article.setWeight(Article.Article_Common);
        mapper.saveArticleBody(article.getBody());
        article.setBodyId(article.getBody().getId());
        article.setCategoryId(article.getCategory().getId());
        mapper.saveArticle(article);
        tagMapper.insertArticleTag(article.getTagList(),article.getId());
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        Article oldArticle = mapper.getBaseArticleById(article.getId());

        oldArticle.setTitle(article.getTitle());
        oldArticle.setSummary(article.getSummary());
        oldArticle.setBody(article.getBody());
        oldArticle.setCategory(article.getCategory());
        article.setCategoryId(oldArticle.getCategory().getId());
        article.getBody().setId(oldArticle.getBodyId());
        mapper.updateArticleBody(article.getBody());
        oldArticle.setTagList(article.getTagList());
        tagMapper.deleteArticleTagByArticleId(article.getId());
        tagMapper.insertArticleTag(article.getTagList(),article.getId());
        mapper.updateArticle(oldArticle);
    }


}

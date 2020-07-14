package com.knight.blog.service.impl;

import com.knight.blog.common.util.UserUtils;
import com.knight.blog.entity.Article;
import com.knight.blog.entity.Comment;
import com.knight.blog.mapper.ArticleMapper;
import com.knight.blog.mapper.CommentMapper;
import com.knight.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper mapper;

    @Autowired
    ArticleMapper articleMapper;

//    @Override
//    public List<Comment> getAllComments() {
//        return mapper.getAllComments();
//    }
//
//    @Override
//    public Comment getParentCommentById(int id) {
//        return mapper.getParentCommentById(id);
//    }
//
//    @Override
//    public Comment getAllCommentsByParentId(int pid) {
//        return mapper.getAllCommentsByParentId(pid);
//    }
//
//    @Override
//    public List<Comment> getCommentsByArticleId(int id) {
//        return mapper.getCommentsByArticleId(id);
//    }

    @Override
    public List<Comment> getParentCommentsByArticleId(int id) {
        return mapper.getParentCommentsByArticleId(id);
    }

    @Override
    @Transactional
    public Comment saveCommentAndChangeCounts(Comment comment) {

        int count = 1;
        Article a = articleMapper.getBaseArticleById(comment.getArticle().getId());
        a.setCommentCounts(a.getCommentCounts()+count);
        articleMapper.updateCount(a.getId(),a.getCommentCounts());
        comment.setAuthor(UserUtils.getCurrentUser());
        comment.setAuthorId(UserUtils.getCurrentUser().getId());
        comment.setArticleId(comment.getArticle().getId());
        comment.setCreateDate(new Date());

        if(null==comment.getParent())
        {
            comment.setLevel("0");
        }
        else
        {
            if(null== comment.getToUser())
            {
                comment.setLevel("1");
            }
            else
            {
                comment.setLevel("2");
            }
        }
        mapper.saveComment(comment);
        return comment;
    }
}

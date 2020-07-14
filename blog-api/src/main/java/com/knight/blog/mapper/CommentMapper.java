package com.knight.blog.mapper;

import com.knight.blog.entity.Article;
import com.knight.blog.entity.Comment;

import java.util.List;

public interface CommentMapper {
    //List<Comment> findByArticleAndLevelOrderByCreateDateDesc(Article a, String level);

    //List<Comment> findAllByArticleId(int id);

//    List<Comment> getAllComments();
//
//    List<Comment> getCommentsByArticleId(int id);
//
//    Comment getAllCommentsByParentId(int pid);
//
//    Comment getParentCommentById(int id);

    List<Comment> getParentCommentsByArticleId(int id);

    int saveComment(Comment comment);
}

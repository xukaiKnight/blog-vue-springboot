package com.knight.blog.service;

import com.knight.blog.entity.Comment;

import java.util.List;

public interface CommentService {
//    List<Comment> getAllComments();
//
//    Comment getParentCommentById(int id);
//
//    Comment getAllCommentsByParentId(int pid);
//
//    List<Comment> getCommentsByArticleId(int id);

    List<Comment> getParentCommentsByArticleId(int id);

    Comment saveCommentAndChangeCounts(Comment comment);
}

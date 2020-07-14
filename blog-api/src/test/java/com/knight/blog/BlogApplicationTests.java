package com.knight.blog;

import com.knight.blog.entity.Article;
import com.knight.blog.entity.Comment;
import com.knight.blog.entity.Tag;
import com.knight.blog.mapper.CommentMapper;
import com.knight.blog.service.ArticleService;
import com.knight.blog.service.CommentService;
import com.knight.blog.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @Autowired
    TagService tagService;


    @Test
    void contextLoads() {

        List<Article> list =  articleService.getAllArticles();
        list.stream().map(Article::getSummary).forEach(System.out::println);
    }

    @Test
    void testCommentService(){
//        List<Comment> list =  commentService.getAllComments();
//        list.stream().map(Comment::getContent).forEach(System.out::println);
        //Comment comment = commentService.getParentCommentById(2);
//        List<Comment> list = commentService.getCommentsByArticleId(1);
//        System.out.println("1");
//        for(Comment comment1 : comment.getChildren())
//        {
//            comment1.setParent(comment);
//        }
        //System.out.println(comment.getContent());
    }

    @Test
    void testTagService()
    {
        List<Tag> tagList = tagService.getTagListByArticleId(1);
        System.out.println("1");
    }

}

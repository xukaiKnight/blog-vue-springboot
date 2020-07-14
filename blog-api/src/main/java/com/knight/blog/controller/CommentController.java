package com.knight.blog.controller;

import com.knight.blog.common.constant.ResultCode;
import com.knight.blog.common.result.Result;
import com.knight.blog.entity.Comment;
import com.knight.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/article/{id}")
    public Result listCommentsByArticleId(@PathVariable("id") Integer id)
    {
        Result r = new Result();
        if(id<0)
        {
            r.setResultCode(ResultCode.PARAM_IS_BLANK);
            return r;
        }

        List<Comment> comments = commentService.getParentCommentsByArticleId(id);
        r.setResultCode(ResultCode.SUCCESS);
        r.setData(comments);
        return r;
    }

    @PostMapping("/create/change")
    public Result saveCommentAndChangeCounts(@RequestBody Comment comment)
    {
        Comment c = commentService.saveCommentAndChangeCounts(comment);
        Result r = Result.success(c);
        return r;
    }
}

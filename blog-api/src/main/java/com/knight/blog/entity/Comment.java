package com.knight.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Comment {
    private Integer id;

    private String content;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm", timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy.MM.dd HH:mm")
    private Date createDate;

    private Integer articleId;

    private Integer authorId;

    private User author;

    private Integer parentId;

    private Comment parent;

    private Integer toUid;

    private User toUser;

    private List<Comment> children;
    
    private String level;

    private Article article;
}

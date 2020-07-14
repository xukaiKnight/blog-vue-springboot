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
public class Article {
    public static final int Article_Common = 0;
    private Integer id;

    private Integer commentCounts;

//    @JSONField(format = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern="yyyy.MM.dd HH:mm", timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy.MM.dd HH:mm")
    private Date createDate;

    private String summary;

    private String title;

    private Integer viewCounts;

    private Integer weight;

    private Integer authorId;

    private Integer bodyId;

    private Integer categoryId;

    private User author;

    private ArticleBody body;

    private Category category;

    private List<Tag> tagList;

    private List<Comment> commentList;
}

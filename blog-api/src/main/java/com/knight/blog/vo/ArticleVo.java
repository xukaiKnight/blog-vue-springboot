package com.knight.blog.vo;

import com.knight.blog.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticleVo extends Article {
    private Integer year;

    private Integer month;

    private Integer tagId;

    private Integer categoryId;

    private Integer count;
}

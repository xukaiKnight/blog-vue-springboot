package com.knight.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {
    private Integer id;

    private String avatar;

    private String categoryName;

    private String description;
}

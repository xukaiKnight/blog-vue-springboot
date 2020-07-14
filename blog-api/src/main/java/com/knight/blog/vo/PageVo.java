package com.knight.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageVo {
    private Integer pageNumber;

    private Integer pageSize;

    private String name;

    private String sort;

}

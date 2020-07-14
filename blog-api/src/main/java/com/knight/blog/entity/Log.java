package com.knight.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Log {
    private int id;

    private Date createDate;

    private String ip;

    private String method;

    private String module;

    private String nickName;

    private String operation;

    private String params;

    private Long time;

    private Long userId;
}

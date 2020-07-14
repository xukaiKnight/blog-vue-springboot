package com.knight.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {
    private Integer id;

    private String account;

    private boolean isAdmin;

    private String avatar;

    private Date createDate;

    private boolean isDeleted;

    private String email;

    private Date lastLogin;

    private String mobilePhoneNumber;

    private String nickName;

    private String password;

    private String salt;

    private String status;
}

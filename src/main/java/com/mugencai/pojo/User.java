package com.mugencai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private Date createTime;
    private String email;
    private String nickname;
    private String password;
    private int type;
    private Date updateTime;
    private String username;
    private String avatar;

    private List<Article> articles;

}

package com.mugencai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.font.StandardGlyphVector;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private int id;

    private boolean appreciation;

    private boolean commentabled;

    private String content;

    private Date createTime;

    private String firstPicture;

    private String flag;

    private boolean published;

    private boolean recommend;

    private boolean shareStatement;

    private String title;

    private Date updateTime;

    private int views;

    private String tagIds;
    private String description;

    private int typeId;

    private Type type;


}

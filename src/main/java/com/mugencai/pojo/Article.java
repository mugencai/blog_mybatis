package com.mugencai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int userId;


    private Type type;
    private User user;


    private List<Tag> tags;

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }


    //convert list of tags to string, like "1,2,3"
    private String tagsToIds(List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(Tag tag: tags){
                if(flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }


}

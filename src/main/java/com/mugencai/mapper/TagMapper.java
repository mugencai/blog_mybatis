package com.mugencai.mapper;

import com.mugencai.pojo.Article;
import com.mugencai.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    int addTag(Tag tag);

    int deleteTag(int id);

    int updateTag(Tag tag);

    Tag getTag(int id);

    List<Tag> listTag();

    List<Tag> listBlogTag(); /*前台显示所有标签（多对多）*/


}

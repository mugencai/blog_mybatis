package com.mugencai.mapper;


import com.mugencai.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogAndTagMapper {

    int addBlogAndTag(BlogAndTag blogAndTag);

    int deleteByBlogId(int blogId);

    List<BlogAndTag> listByBlogId(int blogId);


}

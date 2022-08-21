package com.mugencai.service;


import com.mugencai.mapper.BlogAndTagMapper;
import com.mugencai.pojo.BlogAndTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogAndTagServiceImpl implements BlogAndTagService{


    @Autowired
    BlogAndTagMapper blogAndTagMapper;


    @Override
    public int deleteByBlogId(int blogId) {
        return blogAndTagMapper.deleteByBlogId(blogId);
    }

    @Override
    public List<BlogAndTag> listByBlogId(int blogId) {
        return blogAndTagMapper.listByBlogId(blogId);
    }
}

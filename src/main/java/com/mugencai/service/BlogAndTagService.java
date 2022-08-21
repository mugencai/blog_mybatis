package com.mugencai.service;


import com.mugencai.pojo.BlogAndTag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogAndTagService {

    int deleteByBlogId(int blogId);

    List<BlogAndTag> listByBlogId(int blogId);
}

package com.mugencai.service;

import com.mugencai.pojo.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {

    int addTag(Tag tag);

    int deleteTag(int id);

    int updateTag(Tag tag);

    Tag getTag(int id);

    List<Tag> listTag();

}

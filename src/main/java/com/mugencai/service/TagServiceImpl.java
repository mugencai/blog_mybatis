package com.mugencai.service;

import com.mugencai.mapper.TagMapper;
import com.mugencai.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    TagMapper tagMapper;

    @Override
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public int deleteTag(int id) {
        return tagMapper.deleteTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public Tag getTag(int id) {
        return tagMapper.getTag(id);
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }
}

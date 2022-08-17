package com.mugencai.service;

import com.mugencai.mapper.TagMapper;
import com.mugencai.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Tag> getTagByString(String text) {    //从tagIds字符串中获取id，根据id获取tag集合
        List<Tag> tags = new ArrayList<>();
        List<Long> longs = convertToList(text);
        for (Long long1 : longs) {
            tags.add(tagMapper.getTag(Math.toIntExact(long1)));
        }
        return tags;
    }

    private List<Long> convertToList(String ids) {  //把tagIds字符串转换为list集合
//        System.out.println(ids);
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            System.out.println(idarray);
            for (int i=0; i < idarray.length;i++) {
//                System.out.println(idarray[i]);
                list.add(new Long(idarray[i]));
            }
        }
//        System.out.println(list);
        return list;
    }


    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public List<Tag> listBlogTag() {
        return tagMapper.listBlogTag();
    }
}

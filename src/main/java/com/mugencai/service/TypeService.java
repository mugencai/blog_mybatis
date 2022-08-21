package com.mugencai.service;

import com.mugencai.mapper.TypeMapper;
import com.mugencai.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    int addType(Type type);

    int deleteType(int id);

    int updateType(Type type);

    Type getType(int id);

    List<Type> listType();

    List<Type> listBlogType();

}

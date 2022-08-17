package com.mugencai.mapper;

import com.mugencai.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface TypeMapper {

    int addType(Type type);

    int deleteType(int id);

    int updateType(Type type);

    Type getType(int id);

    List<Type> listBlogType(); /*前台获取Type列表（多表联查）*/

    List<Type> listType();

}

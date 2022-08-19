package com.mugencai.mapper;

import com.mugencai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


@Mapper
@Repository
public interface UserMapper {

    User queryByUserNameAndPassWord(@Param("username") String username, @Param("password") String password);

}

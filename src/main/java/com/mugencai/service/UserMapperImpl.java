package com.mugencai.service;

import com.mugencai.mapper.UserMapper;
import com.mugencai.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserMapperImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryByUserNameAndPassWord(String username, String password) {
        return userMapper.queryByUserNameAndPassWord(username, password);
    }

}

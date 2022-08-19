package com.mugencai.service;

import com.mugencai.mapper.UserMapper;
import com.mugencai.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {

    User queryByUserNameAndPassWord(String username, String password);


}

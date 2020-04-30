package com.example.catchstars.dao;

import com.example.catchstars.model.User;
import com.example.catchstars.model.UserInfo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    UserInfo selectByName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
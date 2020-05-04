package com.example.catchstars.serviceImpl;

import com.example.catchstars.dao.UserMapper;
import com.example.catchstars.model.User;
import com.example.catchstars.resource.UserInfo;
import com.example.catchstars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserInfo(String userName) {
        return userMapper.selectByName(userName);
    }

    public boolean valiteUser(String name, String password) {
        UserInfo userInfo = userMapper.selectByName(name);
        if (userInfo != null && userInfo.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean addUser(UserInfo userInfo) {
        UserInfo info = userMapper.selectByName(userInfo.getName());
        if (info != null) {
            return false;
        }
        userMapper.insert(new User(userInfo));
        return true;
    }
}

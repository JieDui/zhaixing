package com.example.catchstars.service;

import com.example.catchstars.resource.UserInfo;

public interface UserService {

    public UserInfo getUserInfo(String userName);

    public boolean valiteUser(String name, String password);

    public boolean addUser(UserInfo userInfo);
}

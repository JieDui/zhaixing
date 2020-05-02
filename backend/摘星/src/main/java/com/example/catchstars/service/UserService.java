package com.example.catchstars.service;

import com.example.catchstars.model.User;
import com.example.catchstars.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

public interface UserService {

    public User getUserInfo(String userName);

}

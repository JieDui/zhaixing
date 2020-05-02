package com.example.catchstars.controller;

import com.example.catchstars.config.WebSecurityConfig;
import com.example.catchstars.dao.UserInfoMapper;
import com.example.catchstars.dao.UserMapper;
import com.example.catchstars.model.User;
import com.example.catchstars.model.UserInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@Api(tags = "测试连接")
@RequestMapping("/starts/user")
public class UserController {
    @Autowired
    UserMapper userMapper ;
    UserInfoMapper userInfoMapper;


    //登录功能
    @PostMapping("/login")
    public String Login(@RequestBody UserInfo userInfo, HttpSession session) {
        String nameInput = userInfo.getName();
        String passwordInput = userInfo.getPassword();

        UserInfo userSearch = userInfoMapper.findByName(nameInput);
        if (userSearch != null) {
            if (passwordInput.equals(userSearch.getPassword())){
                session.setAttribute(WebSecurityConfig.SESSION_KEY,nameInput);
                return "Login success";
            }else {
                return "Password error";
            }

        } else {
            return "account does not exist";
        }
    }

    //注销功能
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

    //获取当前用户信息
    @GetMapping("/info")
    public UserInfo CurrentUserInfo(HttpSession session){
        String name = (String)session.getAttribute(WebSecurityConfig.SESSION_KEY);
        return userInfoMapper.findByName(name);
    }


    @PostMapping("/register")
    public Object add(@RequestBody User user) throws JSONException {
            String name = user.getName();
            User nameSearch = userMapper.findByName(name);
        if (nameSearch != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","用户名已被使用");
            return jsonObject;
        }
        return userMapper.save(user);
    }





    }



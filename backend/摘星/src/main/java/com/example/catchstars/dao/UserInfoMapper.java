package com.example.catchstars.dao;

import com.example.catchstars.model.User;
import com.example.catchstars.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoMapper extends JpaRepository<UserInfo,Integer>  {
    UserInfo findByName(String Name);
}

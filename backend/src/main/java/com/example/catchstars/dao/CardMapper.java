package com.example.catchstars.dao;
import com.example.catchstars.resource.CardInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.catchstars.model.Card;

@Mapper
public interface CardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

    List<Card> selectByUserId(@Param("userId")Integer userId);

    List<CardInfo> selectByUserIdPage(@Param("userId")Integer userId,
                                      @Param("outDate") boolean outDate);
}
package com.example.catchstars.dao;

import com.example.catchstars.model.Cardandwebsite;
import com.example.catchstars.model.Website;
import org.apache.ibatis.annotations.Param;import java.util.List;

public interface CardandwebsiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cardandwebsite record);

    int insertSelective(Cardandwebsite record);

    Cardandwebsite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cardandwebsite record);

    int updateByPrimaryKey(Cardandwebsite record);

    List<Website> selectByCardId(@Param("cardId") Integer cardId);
}
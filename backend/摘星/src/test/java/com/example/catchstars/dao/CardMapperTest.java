package com.example.catchstars.dao;

import com.example.catchstars.model.Card;
import com.example.catchstars.model.Website;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class CardMapperTest {
    @Resource
    CardMapper cardMapper;

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
        Card card=cardMapper.selectByPrimaryKey(1);
        for(Website website:card.getWebsites()){
            System.out.println(website.toString());
        }
    }
}
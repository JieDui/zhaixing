package com.example.catchstars.dao;

import com.example.catchstars.model.Card;
import com.example.catchstars.model.Website;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class CardandwebsiteMapperTest {
    @Resource
    CardandwebsiteMapper cardandwebsiteMapper;

    @Test
    public void selectByCardIdTest(){
        List<Website> websites=cardandwebsiteMapper.selectByCardId(1);
        for(Website site:websites){
            System.out.println(site.toString());
        }
    }
}
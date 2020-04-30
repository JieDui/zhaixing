package com.example.catchstars.dao;

import com.example.catchstars.model.Card;
import com.example.catchstars.model.User;
import com.example.catchstars.model.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserMapperTest {
    @Resource
    private UserMapper mapper;

//    @BeforeClass
//    public static void setUpMybatisDatabase() {
//        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserMapperTestConfiguration.xml"));
//        //you can use builder.openSession(false) to not commit to database
//        mapper = builder.getConfiguration().getMapper(UserMapper.class, builder.openSession(true));
//    }

    @Test
    public void testSelectByPrimaryKey() throws FileNotFoundException {
        User user=mapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
        List<Card> cards=user.getCards();
        for(int i=0;i<cards.size();i++){
            System.out.println("卡片"+(i+1)+":"+cards.get(i).toString());
        }
    }

    @Test
    public void testSelectByName() {
        UserInfo userInfo = mapper.selectByName("asp");
        System.out.println(userInfo.toString());
    }
}

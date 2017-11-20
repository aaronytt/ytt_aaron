package test.controller;

import com.ytt.mapper.RUserMapper;
import com.ytt.model.RUser;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/spring/spring-mybatis.xml"})
public class UserServiceTest {
    @Autowired
    RUserMapper rUserMapper;

    @org.junit.Test
    public void testUserService(){


    }


}

package test;

import com.ytt.mapper.MemberMapper;
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
public class Test {

    @Autowired
    MemberMapper memberMapper;

    @org.junit.Test
    public void test(){

        List<Map<String,Object>> list = memberMapper.selectAll();

        System.out.println(list);

    }


}

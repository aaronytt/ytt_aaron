package test;

import com.ytt.service.LoginService;
import com.ytt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/spring/applicationContext.xml"})
public class LoginTest {

    @Autowired
    @Qualifier("loginServiceImpl")
    LoginService loginService;

    @Test
    public void testLogin(){

//        loginService.login();

        ((UserService)loginService).updateUesr();

    }

}

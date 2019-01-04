package com.ytt.service.impl;

import com.ytt.model.RUser;
import com.ytt.service.LoginService;
import com.ytt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    UserService userService;

    @Override
    public void login(String username, String password){
        RUser rUser = userService.getUser(username,password);
        if(rUser != null){
            System.out.println(">>>> * "+ username +" * >>>>pass ytt");
        }else {
            System.out.println(">>>> * "+ username +" * >>>>password error");
        }
    }

}

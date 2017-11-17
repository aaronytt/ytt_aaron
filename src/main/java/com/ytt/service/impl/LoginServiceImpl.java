package com.ytt.service.impl;

import com.ytt.annotation.GreetWord;
import com.ytt.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @GreetWord(value = true)
    public void login(){
        System.out.println(">>>>>>>>准许进入ytt");
    }

}

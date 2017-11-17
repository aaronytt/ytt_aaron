package com.ytt.service.impl;

import com.ytt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void updateUesr() {

        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");

    }


}

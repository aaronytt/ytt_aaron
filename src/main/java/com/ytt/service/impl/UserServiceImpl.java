package com.ytt.service.impl;

import com.ytt.mapper.MemberMapper;
import com.ytt.model.RUser;
import com.ytt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    MemberMapper memberMapping;

    @Override
    public RUser getUser(String username, String password) {

        RUser rUser = memberMapping.selectOne(username,password);

        return null;
    }

    @Override
    public void updateUesr() {

        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");

    }


}

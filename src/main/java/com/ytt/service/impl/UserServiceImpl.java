//package com.ytt.service.impl;
//
//import com.ytt.mapper.RUserMapper;
//import com.ytt.model.RUser;
//import com.ytt.model.example.RUserExample;
//import com.ytt.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
//
//    @Autowired
//    RUserMapper rUserMapper;
//    @Autowired
//    MessageSource messageSource;
//
//    @Override
//    public RUser selectUserById(Integer id) {
//
//        RUserExample rUserExample = new RUserExample();
//        RUserExample.Criteria criteria = rUserExample.createCriteria();
//        criteria.andIdEqualTo(id);
//        List<RUser> rUsers = rUserMapper.selectByExample(rUserExample);
//        if(!rUsers.isEmpty()){
//            return rUsers.get(0);
//        }
//        return null;
//    }
//
//    @Override
//    public void updateUesr() {
//        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");
//    }
//
//}

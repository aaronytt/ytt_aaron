//package com.ytt.section;
//
//import com.ytt.service.UserService;
//import com.ytt.service.impl.UserServiceImpl;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.DeclareParents;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoginAspect {
//
//    @Before("@annotation(com.ytt.annotation.GreetWord)")
//    public void greetTo(){
//        System.out.println(">>>>>>>>>ytt欢迎你");
//    }
//
//    @DeclareParents(value = "com.ytt.service.impl.LoginServiceImpl",defaultImpl = UserServiceImpl.class)
//    public UserService userService;
//
//}

package com.ytt.controller;

import com.ytt.service.LoginService;
import com.ytt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping
    public String login(){
        return "/login/login";
    }

    @RequestMapping("into")
    public String loginInto(String username, String password){

        loginService.login(username,password);

        return null;

    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String[] login(String username, String password){
//        loginService.login(username,password);
//        ((UserService)loginService).updateUesr();
//        return new String[]{"welcome","come"};
//    }

}

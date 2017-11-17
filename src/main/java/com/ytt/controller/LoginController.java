package com.ytt.controller;

import com.ytt.service.LoginService;
import com.ytt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("loginServiceImpl")
    LoginService loginService;

    @RequestMapping
    public String login(){
        return "/login/login";
    }

    @RequestMapping("into")
    public String loginCheck(){



        return null;

    }

    @RequestMapping("/login")
    @ResponseBody
    public String[] loginInto(){
        loginService.login();
        ((UserService)loginService).updateUesr();
        return new String[]{"welcome","come"};
    }

}

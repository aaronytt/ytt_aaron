package com.ytt.controller;

import com.ytt.model.commen.dto.ReturnDto;
import com.ytt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public ReturnDto getUserById(@PathVariable("id") Integer id){
        return ReturnDto.buildSuccessReturnDto(userService.selectUserById(id));
    }


}

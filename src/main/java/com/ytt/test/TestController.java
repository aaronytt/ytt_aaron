package com.ytt.test;

import com.ytt.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Autowired
    MemberMapper memberMapper;


    @RequestMapping("/demo")
    public String test(){

        LOGGER.info("来了");
        return "/demo";
    }

    @RequestMapping("/member")
    @ResponseBody
    public List<Map<String,Object>> get(){
        return memberMapper.selectAll();
    }


}

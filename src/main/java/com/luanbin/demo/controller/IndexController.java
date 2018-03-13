package com.luanbin.demo.controller;

import com.luanbin.demo.data.UserDo;
import com.luanbin.demo.mapper.UserMapper;
import com.luanbin.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Hello Spring Boot!";
    }

    @RequestMapping(value = "/getUserName")
    public String getUserName(Integer id){
        LOGGER.info("getUserName by id:{}", id);
        UserDo userDo = userMapper.getUserById(id);
        LOGGER.info("getUserName by id:{}, name:{}", id, userDo.getLoginName());
        return userDo.getLoginName();
    }

    @RequestMapping(value = "/getEnvInfo")
    public String getEnvInfo(Integer id){
        return testService.say();
    }

    @RequestMapping(value = "/testFreeMaker")
    public ModelAndView testFreeMaker(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "freeMaker");
        return modelAndView;
    }
}

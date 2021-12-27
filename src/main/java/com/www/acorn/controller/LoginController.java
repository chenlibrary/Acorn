package com.www.acorn.controller;


import com.alibaba.fastjson.JSONObject;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {



    @Autowired
    private LoginService loginService;


    @RequestMapping( value = "/login" , method = RequestMethod.POST)
    public Object login(@RequestBody JSONObject json) {
        log.info("执行login方法");


        UniversalityDto login = loginService.login(json);


        // 返回json 字符串给前端
        return login;
    }



}

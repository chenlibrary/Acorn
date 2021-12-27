package com.www.acorn.controller;

import com.alibaba.fastjson.JSONObject;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService RegisterService;

    @RequestMapping( value = "/register" , method = RequestMethod.POST)
    public Object register(@RequestBody JSONObject json) {


        UniversalityDto register = RegisterService.register(json);


        // 返回json 字符串给前端
        return register;
    }
}

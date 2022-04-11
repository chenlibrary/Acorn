package com.www.acorn.controller;


import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.dto.UserDto;
import com.www.acorn.service.LoginService;
import com.www.acorn.service.RegisterService;
import com.www.acorn.service.UserService;
import com.www.acorn.tool.UserTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录,注册，修改密码...
 */

@Slf4j
@RestController
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService RegisterService;

    @Autowired
    private UserTool userTool;

    @Autowired
    private UserService userServiceImp;

    /**
     * 用户登录
     */
    @RequestMapping( value = "/login")
    public Object login(@RequestBody @Validated(UserDto.login.class) UserDto userDto) {
        log.info("执行login方法");


        UniversalityDto login = loginService.login(userDto);


        // 返回json 字符串给前端
        return login;
    }


    /**
     * 用户注册
     */
    @RequestMapping( value = "/register" )
    public Object register(@RequestBody @Validated(UserDto.register.class) UserDto userDto) {




        UniversalityDto register = RegisterService.register(userDto);


        // 返回json 字符串给前端
        return register;
    }

    /**
     * 用户修改密码
     */
    @RequestMapping( value = "/updatePass" )
    public Object updatePass(@RequestBody @Validated(UserDto.updatePass.class) UserDto userDto, HttpServletRequest httpServletRequest){


        String userid = userTool.getUserToken(httpServletRequest);


        UniversalityDto universalityDto= userServiceImp.updatepass(userDto, userid);



        return universalityDto;
    }
}

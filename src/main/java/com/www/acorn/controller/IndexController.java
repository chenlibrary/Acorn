package com.www.acorn.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.www.acorn.model.User;
import com.www.acorn.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;


    @RequestMapping( value = "/index" , method = RequestMethod.POST)
    public Object login(@RequestBody JSONObject json) {


        PageInfo<User> userPageInfo = indexService.indexPage(json);


        // 返回json 字符串给前端
        return userPageInfo;
    }


}

package com.www.acorn.controller;


import com.www.acorn.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class IndexController {

    @Autowired
    private IndexService indexService;


//    @RequestMapping( value = "/index" )
//    public Object login(@RequestBody JSONObject json) {
//
//
//        PageInfo<User> userPageInfo = indexService.indexPage(json);
//
//
//        // 返回json 字符串给前端
//        return userPageInfo;
//    }


}

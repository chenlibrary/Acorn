package com.www.acorn.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.www.acorn.mapper.IndexMapper;
import com.www.acorn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndexService {

    @Autowired
    private IndexMapper indexMapper;


    public PageInfo<User> indexPage(JSONObject json){
        Integer pageNum = json.getInteger("pageNum");
        Integer pageSize = json.getInteger("pageSize");

        PageHelper.startPage(pageNum, pageSize);
        List<User> indexUser = indexMapper.findIndex();

        PageInfo<User> indexUserPageInfo = new PageInfo<>(indexUser);


        return  indexUserPageInfo;

    }


    public String indexDetailPage(){

        return  null;
    }



}

package com.www.acorn.service;


import com.alibaba.fastjson.JSONObject;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class RegisterService {
    @Autowired
    private UserMapper userMapper;

    public UniversalityDto register(JSONObject json){
        String email = json.getString("email");
        String user = json.getString("user");
        String pass = json.getString("pass");
        String nickname = json.getString("nickname");

        int i = userMapper.insertUser(user,email,pass,nickname);

        UniversalityDto uld=new UniversalityDto();
        Map<String,String> map=new  HashMap<String,String>();

        if(i>0){
            uld.setCode("200");
            uld.setData(map);
            uld.setMsg("");
            uld.setSucceedFlag(true);
        }else{
            uld.setCode("500");
            uld.setData(map);
            uld.setMsg("");
            uld.setSucceedFlag(false);
        }


        return uld;
    }


}

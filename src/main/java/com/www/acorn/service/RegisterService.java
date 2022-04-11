package com.www.acorn.service;


import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.dto.UserDto;
import com.www.acorn.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class RegisterService {
    @Autowired
    private MyUserMapper userMapper;

    public UniversalityDto register(UserDto userDto){

        String email = userDto.getEmail();
        String user = userDto.getUser();
        String pass = userDto.getPass();
        String nickname = userDto.getNickname();



        int i = userMapper.insertUser(user,email,pass,nickname);

        UniversalityDto uld=new UniversalityDto();
        Map<String,String> map=new  HashMap<String,String>();

        if(i>0){
            uld.setCode(200);
            uld.setData(map);
            uld.setMsg("");
            uld.setSucceedFlag(true);
        }else{
            uld.setCode(500);
            uld.setData(map);
            uld.setMsg("");
            uld.setSucceedFlag(false);
        }


        return uld;
    }


}

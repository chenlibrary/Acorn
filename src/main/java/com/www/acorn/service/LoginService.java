package com.www.acorn.service;

import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.dto.UserDto;
import com.www.acorn.mapper.MyUserMapper;
import com.www.acorn.tool.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LoginService {

    @Autowired
    private MyUserMapper userMapper;

    @Autowired
    private JwtUtils jwtUtils;


    public UniversalityDto login(UserDto userDto){

        UniversalityDto ud=new UniversalityDto();

        String user = userDto.getUser();
        String pass = userDto.getPass();

        List<Map> myUser = userMapper.findUser(user, pass);

        String user_id =(String) myUser.get(0).get("user_id");
        String token= jwtUtils.generateToken(user_id);
        myUser.get(0).put("token",token);


        ud.setCode(200);
        ud.setData(myUser.get(0));
        ud.setMsg("");
        ud.setSucceedFlag(true);


        return ud;


    }
}

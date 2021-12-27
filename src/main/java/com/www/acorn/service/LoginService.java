package com.www.acorn.service;

import com.alibaba.fastjson.JSONObject;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LoginService {

    @Autowired
    private UserMapper userMapper;



    public UniversalityDto login(JSONObject json){

        UniversalityDto ud=null;


        String user = json.getString("user");
        String pass = json.getString("pass");

        //判断是否为传入的用户和密码是否为空
        boolean userEmpty = StringUtils.isEmpty(user);
        boolean passEmpty = StringUtils.isEmpty(pass);
        if(!userEmpty||!passEmpty){
            //用户和密码不为空
            //进行格式校验
            List<Map> myUser = userMapper.findUser(user, pass);

            myUser.get(0).put("token","123456789");


            ud=new UniversalityDto();
            ud.setCode("200");
            ud.setData(myUser.get(0));
            ud.setMsg("");
            ud.setSucceedFlag(true);



//            UniversalityDto ud=new UniversalityDto();
//
//            ud.setData(myUser.get(0).toString());


            return ud;

        }else{
            //用户和密码为空
            ud.setCode("500");
            ud.setMsg("用户和密码为空");
            ud.setSucceedFlag(false);
            return ud;
        }


    }
}

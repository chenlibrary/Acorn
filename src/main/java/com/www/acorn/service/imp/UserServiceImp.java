package com.www.acorn.service.imp;

import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.dto.UserDto;
import com.www.acorn.mbgmapper.UserMapper;
import com.www.acorn.model.User;
import com.www.acorn.service.UserService;
import com.www.acorn.tool.JwtUtils;
import com.www.acorn.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private UserTool userTool;

    @Override
    public UniversalityDto updatepass(UserDto userDto, String userid) {
        String oldpass=userDto.getOldPass();
        String newpass=userDto.getNewPass();

        boolean b = userTool.OldPassEqualsNewPass(oldpass,newpass);

        if(b){
            //抛新旧密码相同异常
        }


        User user=new User();
        user.setUserId(Integer.valueOf(userid));
        user.setPass(newpass);

        int i = userMapper.updateByPrimaryKey(user);


        if(i>0){
            return  UniversalityDto.success(null);
        }else{
            return  UniversalityDto.failed();
        }



    }
}

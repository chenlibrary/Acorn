package com.www.acorn.tool;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class UserTool {

    public String getUserToken(HttpServletRequest request){

        String userId = (String)request.getAttribute("userId");

        return userId;
    }

    //验证用户和密码是否为空
    public boolean OldPassEqualsNewPass(String oldpass,String newpass){

        boolean b = oldpass.equals(newpass);

        return b;

    }

    //验证用户和密码是否为空
    public void loginEmpty(){

    }

    //生成用户token 需要经过加密（加密方式（用户的ID自身+登录的日+key进行加密））
    //token 规则ID+密码（密码是MD5密码）再进行3DES加密返回
    public void encryptionToken(){



    }

    //生成用户token 需要经过解密（解密）
    public String decryptionToken(){

        return  "";
    }

    //验证用户名称重复
}

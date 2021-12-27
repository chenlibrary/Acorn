package com.www.acorn.tool;

public class UserTool {

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

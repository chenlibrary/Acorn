package com.www.acorn.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;



public interface MyUserMapper {

    @Select("select * from user where user=#{user}")
    List<Map> findUserId(@Param("user")String user);

    @Select("select * from user where user=#{user} and pass=#{pass}")
    List<Map> findUser(@Param("user")String user, @Param("pass")String pass);

    //user,email,pass,nickname
    @Select("insert into  user ('user','pass','email','nickname') values(#{user},#{email},#{pass},#{nickname})")
    int  insertUser(@Param("user")String user,@Param("email")String email, @Param("pass")String pass,@Param("nickname")String nickname);


//    @Select("update  user set pass=#{newpass} where user=#{user} and pass=#{oldpass}")
//    int updateUser(@Param("user")String user, @Param("oldpass")String oldpass,@Param("newpass")String newpass);

}

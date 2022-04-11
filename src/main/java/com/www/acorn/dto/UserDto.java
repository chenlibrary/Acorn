package com.www.acorn.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 登录用户类
 */
@Data
public class UserDto implements Serializable {


    @NotBlank(message = "账户不能为空！",groups ={UserDto.login.class,UserDto.register.class})
    private String user;
    @NotEmpty(message = "密码不能为空！",groups ={UserDto.login.class,UserDto.register.class})
    private String pass;


    @Email(message="邮箱格式错误！",groups ={UserDto.register.class})
    private String email;
    @NotEmpty(message = "昵称不能为空",groups ={UserDto.register.class})
    private String nickname;

    @NotEmpty(message = "旧密码不能为空！",groups ={UserDto.updatePass.class})
    private String oldPass;
    @NotEmpty(message = "新密码不能为空！",groups ={UserDto.updatePass.class})
    private String newPass;




//    用于校验判断
    public interface login {
    }

    public interface register {
    }

    public interface updatePass {
    }




}

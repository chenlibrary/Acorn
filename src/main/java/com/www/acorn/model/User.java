package com.www.acorn.model;


import lombok.Data;

@Data
public class User {
    private Integer userId;//    用户主键	user_id	int			TRUE	FALSE	TRUE
    private String user;//    账户	user	varchar(20)	20		FALSE	FALSE	FALSE
    private String pass;//    密码	pass	varchar(20)	20		FALSE	FALSE	FALSE
    private String nickname;//    昵称	nickname	varchar(20)	20		FALSE	FALSE	FALSE
    private String icon;//    头像	icon	varchar(100)	100		FALSE	FALSE	FALSE
    private String email;//    邮箱	email	varchar(100)	100		FALSE	FALSE	FALSE
    private String adminFlag;//    管理员标记	admin_flag	varchar(2)	2		FALSE	FALSE	FALSE
    private Integer blacklistFlag;//    黑名单标记	blacklist_flag	int			FALSE	FALSE	FALSE
    private String time;//    时间戳	time	datetime			FALSE	FALSE	FALSE

}

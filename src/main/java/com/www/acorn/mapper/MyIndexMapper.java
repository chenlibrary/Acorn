package com.www.acorn.mapper;


import com.www.acorn.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface MyIndexMapper {


    @Select("select * from user")
    List<User> findIndex();


    //条件 本月 本周 本日 按浏览量
    // paper 表
//    p.paper_id,
//    p.title,
//    p.circle_id,
//    p.time,
//    p.user_id,
//    p.cover,
//    p.content,
//
//    // user 表
//    u.user,
//    u.nickname,
//    u.icon,
//    u.admin_flag,
//
//    // circle 表
//    c.name:v,
//
//    // comment 表
//    com.comcomment_count,
//
//    // paper_visit 表
//    pv.paper_view_count
    @Select("<script> " +
            "select      " +
            "    p.paper_id, " +
            "    p.title, " +
            "    p.circle_id, " +
            "    p.time, " +
            "    p.user_id, " +
            "    p.cover, " +
            "    p.content, " +
            "    u.user, " +
            "    u.nickname, " +
            "    u.icon, " +
            "    u.admin_flag, " +
            "    c.name, " +
            "    (select count(1) from comment where comment.paper_id=p.paper_id ) comcomment_count, " +
            "    (select count(1) from paper_visit where paper_visit.paper_id=p.paper_id  ) paper_view_count " +
            " from paper p  " +
            "            left join  user u on u.user_id=p.user_id " +
            "            left join  circle c on c.circle_id=p.circle_id " +
            "            left join  comment com on com.paper_id=p.paper_id " +
            "            left join  paper_visit pv on pv.paper_id=p.paper_id " +
            "where p.draft_flag=0 and p.del_flag=0 " +
            "<choose> " +
            "            <when test='type == day'> " +
            "                AND day(p.time) = #{time} order by paper_view_count desc" +
            "            </when> " +
            "            <when test='type == week'> " +
            "                 AND week(p.time) = #{time} order by paper_view_count desc" +
            "            </when> " +
            "            <otherwise> " +
            "                AND month(p.time) = #{time} order by paper_view_count desc" +
            "            </otherwise> " +
            "</choose> " +
            "</script>")
    List<Map> findHotData(String time,String type);



    @Select("select notice.*,user.user,user.nickname,user.icon" +
            "    from notice " +
            "    LEFT JOIN  user on notice.user_id=user.user_id")
    List<Map> findNoticeData();








}

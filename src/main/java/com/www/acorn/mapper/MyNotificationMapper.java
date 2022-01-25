package com.www.acorn.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface MyNotificationMapper {


//    notification/通知表 和 notification_status/通
    @Select("</script>"+
            "select n.notification_id,n.title,n.content,n.time,status  from  notification  n " +
            "LEFT JOIN notification_status ns on ns.notification_id=n.notification_id " +
            "where  user_id=#{userId} " +
            " <if test='status != null and status != &apos;&apos; '> "+
                "and status=#{status} "+
            " </if> "+
            " order by n.time "+
            "</script>")
       List<Map> findNotification(@Param("userId")String userId, @Param("status")String status);
}

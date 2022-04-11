package com.www.acorn.service.imp;

import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mapper.MyNotificationMapper;
import com.www.acorn.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImp implements NotificationService {

    @Autowired
    private MyNotificationMapper notificationMapper;

    public UniversalityDto getNotification(String userId){

        List<Map> notification = notificationMapper.findNotification(userId, null);

        Map m=new HashMap();
        m.put("ls",notification);


        UniversalityDto universalityDto=UniversalityDto.success(m);




        return  universalityDto;
    }

    @Override
    public UniversalityDto updateNotificationStatus(String userId) {

        //根据userid去通知表（notification）找所有的notification_id
        //然后再去找notification_status/通知状态表，去更新所有通知，把未读改为已读
        int i=notificationMapper.updateNotificationStatusRead(userId);
        if(i>0){
            return UniversalityDto.success("");
        }else{
            return UniversalityDto.failed("更新失败，你没有未读通知");
        }


    }

    @Override
    public UniversalityDto clearNotification(String userId) {
        return null;
    }
}

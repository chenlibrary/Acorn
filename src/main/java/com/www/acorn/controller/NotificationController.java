package com.www.acorn.controller;


import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.NotificationService;
import com.www.acorn.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NotificationController {

    @Autowired
    private UserTool userTool;

    private NotificationService notificationService;

    @RequestMapping(value = "/getNotification",method = RequestMethod.POST)
    public Object getNotification(HttpServletRequest request){

        String userToken = userTool.getUserToken(request);

        UniversalityDto notification = notificationService.getNotification(userToken);


        return notification;
    }

    @RequestMapping(value = "/updateNotificationStatus",method = RequestMethod.POST )
    public Object updateNotificationStatus(HttpServletRequest request){

        String userId= userTool.getUserToken(request);

        UniversalityDto universalityDto = notificationService.updateNotificationStatus(userId);
        return universalityDto;

    }
}

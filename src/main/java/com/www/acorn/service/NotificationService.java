package com.www.acorn.service;

import com.www.acorn.dto.UniversalityDto;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {


    /**
     * 获取未读通知
     */
     UniversalityDto getNotification(String userId);

    /**
     * 更新通知为已读
     */
    UniversalityDto updateNotificationStatus(String userId);

    /**
     * 清空通知(不清楚想干嘛)
     */
    UniversalityDto clearNotification(String userId);
}

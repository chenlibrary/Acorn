package com.www.acorn.service;

import com.www.acorn.dto.HotDto;
import com.www.acorn.dto.UniversalityDto;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {

    /**
     * 获取公告
     * @return
     */
    UniversalityDto noticePage(HotDto hotDto);

    /**
     * 添加公告
     * @return
     */
    UniversalityDto addNotice(String title,
                              String content,
                              String date
    );

    /**
     * 修改公告
     * @return
     */
    UniversalityDto updateNotice(int id,
            String title,
            String lastTitle,
            String content,
            String date
    );

    /**
     * 删除公告
     * @return
     */
    UniversalityDto delNotice(int id);





}

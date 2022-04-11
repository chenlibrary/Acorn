package com.www.acorn.service;

import com.www.acorn.dto.UniversalityDto;
import org.springframework.stereotype.Service;

@Service
public interface FriendshipLinkService {

    /**
     * 获得友情链接
     * @return
     */
    UniversalityDto getFriendshipLink();

    /**
     * 添加友情链接
     * @return
     */
    UniversalityDto addFriendshipLink(String title,String url);

    /**
     * 修改友情链接
     * @return
     */
    UniversalityDto updateFriendshipLink (int id,
            String title,
            String lastTitle,
            String url
    );

    /**
     * 删除友情链接
     * @return
     */
    UniversalityDto delFriendshipLink (int id);
}

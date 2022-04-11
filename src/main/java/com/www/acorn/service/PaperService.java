package com.www.acorn.service;

import com.www.acorn.dto.UniversalityDto;

public interface PaperService {
    /**
     * 获得用户发布的帖子
     */
     UniversalityDto getPostPaper();

    /**
     * 获得用户草稿箱中的帖子
     */
    UniversalityDto getDraftPaper();

    /**
     * 获得用户收藏的帖子
     */
    UniversalityDto getCollectPaper();

    /**
     * 获得回收站中的帖子
     */
    UniversalityDto getRecyclePaper();

    /**
     * 将发布的帖子移到草稿箱
     */
    UniversalityDto moveToDraftPaper();

    /**
     * 将发布的帖子移到回收站
     */
    UniversalityDto delPostPaper();

    /**
     * 删除回收站的帖子
     */
    UniversalityDto removeRecycle();

    /**
     * 移除收藏夹中的帖子
     */
    UniversalityDto removeCollect();

    /**
     * 获得帖子详情
     */
    UniversalityDto getPaperDetail();

    /**
     * 创建贴子
     */
    UniversalityDto createPaper();


}

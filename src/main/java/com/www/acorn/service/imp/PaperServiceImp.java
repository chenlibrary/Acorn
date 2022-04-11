package com.www.acorn.service.imp;

import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.PaperService;

public class PaperServiceImp implements PaperService {
    /**
     * 获得用户发布的帖子
     */
    @Override
    public UniversalityDto getPostPaper() {
        return null;
    }

    /**
     * 获得用户草稿箱中的帖子
     */
    @Override
    public UniversalityDto getDraftPaper() {
        return null;
    }

    /**
     * 获得用户收藏的帖子
     */
    @Override
    public UniversalityDto getCollectPaper() {
        return null;
    }

    /**
     * 获得回收站中的帖子
     */
    @Override
    public UniversalityDto getRecyclePaper() {
        return null;
    }

    /**
     * 将发布的帖子移到草稿箱(发布的怎么回草稿箱???)
     */
    @Override
    public UniversalityDto moveToDraftPaper() {
        return null;
    }

    /**
     * 将发布的帖子移到回收站 (收藏和评论的有关系)
     */
    @Override
    public UniversalityDto delPostPaper() {
        return null;
    }

    /**
     * 删除回收站的帖子
     */
    @Override
    public UniversalityDto removeRecycle() {
        return null;
    }

    /**
     * 移除收藏夹中的帖子
     */
    @Override
    public UniversalityDto removeCollect() {
        return null;
    }

    /**
     * 获得帖子详情
     */
    @Override
    public UniversalityDto getPaperDetail() {
        return null;
    }

    /**
     * 创建贴子
     */
    @Override
    public UniversalityDto createPaper() {
        return null;
    }
}

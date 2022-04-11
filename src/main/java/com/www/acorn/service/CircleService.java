package com.www.acorn.service;


import com.www.acorn.dto.CircleDtoRequest;
import com.www.acorn.dto.SearchCircleRequest;
import com.www.acorn.dto.UniversalityDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface CircleService {


    /**
     *  根据用户id去获取已经关注的圈子
     * @param userid 用户id
     * @return
     */
     UniversalityDto getAttentionCircle(String userid);

    /**
     * 根据用户ID，去找关注的圈子，共同标签最多的圈子推荐
     * @return
     */
     UniversalityDto getRecommendCircle();

    /**
     * 获得官方圈子
     * @return
     */
    UniversalityDto getOfficialCircle();

    /**
     * 获得搜索圈子
     * @return
     */
    UniversalityDto getSearchCircle(SearchCircleRequest searchCircleRequest);

    /**
     *上传临时图片
     */
    String upImg(MultipartFile file);

    /**
     *创建圈子
     */
    UniversalityDto createCircle(CircleDtoRequest createCircleRequest,String userId);



}

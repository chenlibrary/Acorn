package com.www.acorn.controller;


import com.www.acorn.dto.CircleDtoRequest;
import com.www.acorn.dto.SearchCircleRequest;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.CircleService;
import com.www.acorn.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 圈子控制类
 */
@RestController
public class CircleController {


    @Autowired
    private CircleService circleService;
    @Autowired
    private UserTool userTool;



    /**
     * 获取获得用户已关注的圈子
     */
    @RequestMapping(value = "/getAttentionCircle" )
    public Object getAttentionCircle(HttpServletRequest request){


        String userToken = userTool.getUserToken(request);

        UniversalityDto universalityDto = circleService.getAttentionCircle(userToken);


        return universalityDto;
    }

    /**
     *根据用户喜欢圈子的标签来推送圈子(获取全部圈子？？？)
     */
    @RequestMapping(value = "/getRecommendCircle")
    public Object getRecommendCircle(){

        UniversalityDto universalityDto = circleService.getAttentionCircle(null);

        return universalityDto;

    }

    /**
     * 获得官方圈子
     */
    @RequestMapping(value = "/getOfficialCircle",method = RequestMethod.POST)
    public String getOfficialCircle(){

        UniversalityDto officialCircle = circleService.getOfficialCircle();

        return null;
    }

    /**
     * 搜索圈子
     */
    @RequestMapping(value = "/getSearchCircle",method = RequestMethod.POST)
    public Object getSearchCircle(@RequestBody SearchCircleRequest searchCircleRequest){

        UniversalityDto universalityDto = circleService.getSearchCircle(searchCircleRequest);

        return universalityDto;
    }


    /**
     *创建圈子
     */
    @RequestMapping(value = "/createCircle",method = RequestMethod.POST)
    public Object createCircle(@RequestBody @Validated CircleDtoRequest circleDtoRequest, HttpServletRequest request){

        String userId = userTool.getUserToken(request);

        UniversalityDto universalityDto = circleService.createCircle(circleDtoRequest, userId);


        return universalityDto;
    }

    /**
     *上传临时图片
     */
    @RequestMapping(value = "/upImg",method = RequestMethod.POST)
    public Object upImg(@RequestPart("file") MultipartFile[] files, HttpServletRequest request){

        String userId = userTool.getUserToken(request);

        List<String>  imgsrcs=new ArrayList<String>();

        for(MultipartFile  file: files){
            String imgsrc = circleService.upImg(file);

            imgsrcs.add(imgsrc);
        }

        Map m=new HashMap<>();
        m.put("imgsrcs",imgsrcs);

        return UniversalityDto.success(m);
    }
}

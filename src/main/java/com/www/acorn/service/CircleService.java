package com.www.acorn.service;


import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mapper.CircleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CircleService {

    @Autowired
    private CircleMapper circleMapper;

    public UniversalityDto attentionCircle(String userid){

        List<Map> userAttentionCircleList = circleMapper.findUserAttentionCircle(userid);

        //循环根据圈子表ciecle_id取出对应的标签
        for(int i=0;i<userAttentionCircleList.size();i++){
            Map map = userAttentionCircleList.get(i);
            Object ciecle_id = map.get("ciecle_id");
            if(ciecle_id!=null&&!ciecle_id.equals("")){
                List<Map> userCircleTag = circleMapper.findUserCircleTag(ciecle_id.toString());
                map.put("tags",userCircleTag);

            }
        }
        Map m=new HashMap();
        m.put("ls",userAttentionCircleList);

        UniversalityDto universalityDto = new UniversalityDto("200", "", m, true);

        return  universalityDto;



    }
}

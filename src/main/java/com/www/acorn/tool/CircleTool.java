package com.www.acorn.tool;

import com.www.acorn.dto.CircleAndAttentionNumDto;
import com.www.acorn.mapper.MyCircleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CircleTool {
    @Autowired
    private MyCircleMapper circleMapper;

    public List<CircleAndAttentionNumDto>  getTags(List<CircleAndAttentionNumDto>  circleAndAttentionNumDtos){
        for(int i=0;i<circleAndAttentionNumDtos.size();i++){
            CircleAndAttentionNumDto map = circleAndAttentionNumDtos.get(i);
            Integer ciecle_id = map.getCircleId();
            if(ciecle_id!=null&&!ciecle_id.equals("")){
                List<Map> userCircleTag = circleMapper.findUserCircleTag(ciecle_id.toString());
                map.setTags(userCircleTag);

            }
        }
        return  circleAndAttentionNumDtos;

    }

}

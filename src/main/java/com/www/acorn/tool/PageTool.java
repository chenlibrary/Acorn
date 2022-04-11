package com.www.acorn.tool;

import com.github.pagehelper.PageInfo;
import com.www.acorn.dto.UniversalityDto;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PageTool<T> {


    public UniversalityDto getData(List<Map> data){

        PageInfo<Map> mapPageInfo = new PageInfo<>( data);

        //分页后获取需要的数据放在map里面返回
        int PageInfopages = mapPageInfo.getPages();
        List<Map> PageInfolist = mapPageInfo.getList();

        Map m=new HashMap();
        m.put("totalPage",PageInfopages);
        m.put("ls",PageInfolist);


        UniversalityDto universalityDto =UniversalityDto.success(m);

        return  universalityDto;
    }

    public UniversalityDto getDatas(List<T> data){

        PageInfo<T> mapPageInfo = new PageInfo<T>( data);

        //分页后获取需要的数据放在map里面返回
        int PageInfopages = mapPageInfo.getPages();
        List<T> PageInfolist = mapPageInfo.getList();

        Map m=new HashMap();
        m.put("totalPage",PageInfopages);
        m.put("ls",PageInfolist);


        UniversalityDto universalityDto =UniversalityDto.success(m);

        return  universalityDto;
    }
}

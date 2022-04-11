package com.www.acorn.service;

import com.github.pagehelper.PageHelper;
import com.www.acorn.dto.HotDto;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mapper.MyIndexMapper;
import com.www.acorn.tool.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class HotService {

    @Autowired
    private MyIndexMapper indexMapper;
    @Autowired
    private PageTool pageTool;


    public UniversalityDto hotPage(@RequestBody HotDto hotDto){
        //解析json数据


        Integer pageNum = hotDto.getPage();
        Integer pageSize = hotDto.getNum();
        String type = hotDto.getType();
        String time = hotDto.getTime();



        //使用PageHelper插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Map> data = indexMapper.findHotData(time, type);

        UniversalityDto universalityDto = pageTool.getData(data);


        return  universalityDto;
    }
}

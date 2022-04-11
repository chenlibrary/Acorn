package com.www.acorn.service.imp;

import com.github.pagehelper.PageHelper;
import com.www.acorn.dto.HotDto;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mapper.MyIndexMapper;
import com.www.acorn.mbgmapper.NoticeMapper;
import com.www.acorn.model.Notice;
import com.www.acorn.model.NoticeExample;
import com.www.acorn.service.NoticeService;
import com.www.acorn.tool.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class NoticeServiceImp implements NoticeService {

    @Autowired
    private MyIndexMapper indexMapper;

    @Autowired
    private PageTool pageTool;

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public UniversalityDto noticePage(HotDto hotDto){
        //解析json数据

        Integer pageNum = hotDto.getPage();
        Integer pageSize =  hotDto.getNum();


        //使用PageHelper插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<Map> data = indexMapper.findNoticeData();

        UniversalityDto universalityDto = pageTool.getData(data);

        return  universalityDto;
    }


    @Override
    public UniversalityDto addNotice(String title, String content, String date) {

        Notice notice= new Notice();
        notice.setTitle(title);
        notice.setContent(title);
        notice.setTime(new Date(date));

        int i = noticeMapper.insertSelective(notice);

        if(i>0){
            return  UniversalityDto.success(null);
        }else{
            return  UniversalityDto.failed();
        }

    }

    @Override
    public UniversalityDto updateNotice(int id, String title, String lastTitle, String content, String date) {


        //判断新公告是否已存在
        if(!title.equals(lastTitle)){
            NoticeExample example=new NoticeExample();
            NoticeExample.Criteria criteria = example.createCriteria();
            criteria.andTitleEqualTo(title);
            criteria.andNoticeIdNotEqualTo(id);
            List<Notice> blogrolls = noticeMapper.selectByExample(example);

            if(blogrolls.size()>0){
                return  UniversalityDto.failed("新公告已存在");
            }

        }

        Notice notice= new Notice();
        notice.setTitle(title);
        notice.setContent(title);
        notice.setTime(new Date(date));

        int i = noticeMapper.updateByPrimaryKeySelective(notice);


        if(i>0){
            return  UniversalityDto.success(null);
        }else{
            return  UniversalityDto.failed();
        }

    }

    @Override
    public UniversalityDto delNotice(int id) {

        int i = noticeMapper.deleteByPrimaryKey(id);

        if(i>0){
            return  UniversalityDto.success(null);
        }else{
            return  UniversalityDto.failed();
        }


    }
}

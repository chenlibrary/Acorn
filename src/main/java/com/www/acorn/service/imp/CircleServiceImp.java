package com.www.acorn.service.imp;

import com.github.pagehelper.PageHelper;
import com.www.acorn.dto.CircleAndAttentionNumDto;
import com.www.acorn.dto.CircleDtoRequest;
import com.www.acorn.dto.SearchCircleRequest;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.enums.TFStatusTypeEnum;
import com.www.acorn.mapper.MyCircleMapper;
import com.www.acorn.mapper.MyTagMapper;
import com.www.acorn.mbgmapper.CircleMapper;
import com.www.acorn.mbgmapper.CircleTagMapper;
import com.www.acorn.model.Circle;
import com.www.acorn.model.CircleTag;
import com.www.acorn.model.Tag;
import com.www.acorn.service.CircleService;
import com.www.acorn.tool.CircleTool;
import com.www.acorn.tool.ImgTool;
import com.www.acorn.tool.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Service
@Transactional
public class CircleServiceImp implements CircleService {

    @Autowired
    private MyCircleMapper myCircleMapper;

    @Autowired
    private CircleMapper circleMapper;

    @Autowired
    private MyTagMapper myTagMapper;

    @Autowired
    private CircleTagMapper circleTagMapper;




    @Autowired
    private PageTool pageTool;

    @Autowired
    private CircleTool circleTool;

    @Autowired
    private ImgTool imgTool;

    /**
     *  根据用户id去获取已经关注的圈子
     * @param userid 用户id
     * @return
     */
    public UniversalityDto getAttentionCircle(String userid){

        List<Map> userAttentionCircleList = myCircleMapper.findUserAttentionCircle(userid);

        //循环根据圈子表ciecle_id取出对应的标签
        for(int i=0;i<userAttentionCircleList.size();i++){
            Map map = userAttentionCircleList.get(i);
            Object ciecle_id = map.get("ciecle_id");
            if(ciecle_id!=null&&!ciecle_id.equals("")){
                List<Map> userCircleTag = myCircleMapper.findUserCircleTag(ciecle_id.toString());
                map.put("tags",userCircleTag);

            }
        }
        Map m=new HashMap();
        m.put("ls",userAttentionCircleList);

        UniversalityDto universalityDto = UniversalityDto.success(m);

        return  universalityDto;



    }

    /**
     * 根据用户ID，去找关注的圈子，共同标签最多的圈子推荐，或者获得最多人关注的圈子排序
     * @return
     */
    public UniversalityDto getRecommendCircle(){
        List<CircleAndAttentionNumDto> circleAndAttentionNumDtos = myCircleMapper.selectRecommendCircle();


        //循环根据圈子表ciecle_id取出对应的标签
        List<CircleAndAttentionNumDto> circleAndAttentionNumDtosTags = circleTool.getTags(circleAndAttentionNumDtos);

        Map m=new HashMap();
        m.put("ls",circleAndAttentionNumDtosTags);

        UniversalityDto universalityDto = UniversalityDto.success(m);
        return universalityDto;
    }




    /**
     * 获得官方圈子
     * @return
     */
    @Override
    public UniversalityDto getOfficialCircle() {

        List<CircleAndAttentionNumDto> circleAndAttentionNumDtos = myCircleMapper.selectOfficialCircle();

        //循环根据圈子表ciecle_id取出对应的标签
        List<CircleAndAttentionNumDto> circleAndAttentionNumDtosTags = circleTool.getTags(circleAndAttentionNumDtos);


        Map m=new HashMap();
        m.put("ls",circleAndAttentionNumDtosTags);

        UniversalityDto universalityDto = UniversalityDto.success(m);
        return universalityDto;

    }
    /**
     * 搜索圈子
     * @return
     */
    @Override
    public UniversalityDto getSearchCircle(SearchCircleRequest searchCircleRequest) {

        String searchText = searchCircleRequest.getSearchText();
        int pageNum = searchCircleRequest.getPage();
        int pageSize = searchCircleRequest.getNum();

        if(searchText == null || searchText.length() == 0){
            PageHelper.startPage(pageNum, pageSize);
            List<CircleAndAttentionNumDto> circleAndAttentionNumDtos = myCircleMapper.selectAllCircle();

            List<CircleAndAttentionNumDto> circleAndAttentionNumDtosTags = circleTool.getTags(circleAndAttentionNumDtos);
            UniversalityDto datas = pageTool.getDatas(circleAndAttentionNumDtosTags);
            return datas;

        }else{
            PageHelper.startPage(pageNum, pageSize);
            List<CircleAndAttentionNumDto> circleAndAttentionNumDtos = myCircleMapper.selectSearchCircle(searchText);
            List<CircleAndAttentionNumDto> circleAndAttentionNumDtosTags = circleTool.getTags(circleAndAttentionNumDtos);
            UniversalityDto datas = pageTool.getDatas(circleAndAttentionNumDtosTags);

            return datas;
        }

    }

    @Override
    public String upImg(MultipartFile file) {
        String imgsrc = imgTool.imgFile(file);

//        Map m=new HashMap();
//        m.put("imgsrc",imgsrc);

        return  imgsrc;
    }

    @Override
    public UniversalityDto createCircle(CircleDtoRequest createCircleRequest,String userId) {

        String adminFlag = createCircleRequest.getAdminFlag();
        String icon = createCircleRequest.getIcon();
        String intro = createCircleRequest.getIntro();
        String name = createCircleRequest.getName();
        List tagLs = createCircleRequest.getTagLs();

        //组装圈子表
        Circle circle = new Circle();
        circle.setAdminFlag(adminFlag.equals("true")?1:0);
        circle.setIntro(intro);
        circle.setName(name);
        circle.setIcon(icon);
        circle.setDate(new Date());
        circle.setUserId(Integer.valueOf(userId));

        circle.setDelFlag(TFStatusTypeEnum.unok.getType());
        circle.setLimitPostFlag(TFStatusTypeEnum.unok.getType());
        circle.setCurrentLimitFlag(TFStatusTypeEnum.unok.getType());

        //        keyProperty="id" useGeneratedKeys="true"
        int i1 = circleMapper.insertSelective(circle);

        //组装标签表
        List taglist=new ArrayList();
        for(int i=0;i<tagLs.size();i++){
            Tag tag = new Tag();
            tag.setTitle(tagLs.get(i).toString());
            tag.setTime(new Date());
            taglist.add(tag);
        }

        int i2 = myTagMapper.insertTagBatch(taglist);

        //把圈子表和圈子标签表的id插入  他们之间的关系表。
        Integer circleId = circle.getCircleId();
        
        for(int i=0;i<taglist.size();i++){
            Tag tag = (Tag)taglist.get(i);
            Integer tagId = tag.getTagId();

            CircleTag circleTag = new CircleTag();
            circleTag.setCircleId(circleId);
            circleTag.setTagId(tagId);
            circleTag.setTime(new Date());

            circleTagMapper.insertSelective(circleTag);
        }





        return  UniversalityDto.success("");
    }
}

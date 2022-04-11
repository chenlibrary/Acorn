package com.www.acorn.service.imp;

import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.mbgmapper.BlogrollMapper;
import com.www.acorn.model.Blogroll;
import com.www.acorn.model.BlogrollExample;
import com.www.acorn.service.FriendshipLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
public class FriendshipLinkServiceImp implements FriendshipLinkService {

    @Autowired
    private BlogrollMapper blogrollMapper;

    @Override
    public UniversalityDto getFriendshipLink() {

        //查询友情链接表中所以字段
        BlogrollExample example=new BlogrollExample();
        BlogrollExample.Criteria criteria = example.createCriteria();
        List<Blogroll> blogrolls = blogrollMapper.selectByExample(example);


        Map m=new HashMap();
        m.put("ls",blogrolls);

        UniversalityDto universalityDto = UniversalityDto.success(m);

        return universalityDto;
    }

    @Override
    public UniversalityDto addFriendshipLink(String title, String url) {


        //判断标题和url是否已经存在
        BlogrollExample example=new BlogrollExample();
        example.or().andTitleEqualTo(title);
        example.or().andUrlEqualTo(url);
        List<Blogroll> blogrolls = blogrollMapper.selectByExample(example);

        //若小于0或等于0则 标题和url不存在
        if(blogrolls.size()<=0){
            Blogroll blogroll=new Blogroll();
            blogroll.setTitle(title);
            blogroll.setUrl(url);

            int i = blogrollMapper.insertSelective(blogroll);

            if(i>0){
                return  UniversalityDto.success(null);
            }else{
                return  UniversalityDto.failed();
            }
        }else{
            return  UniversalityDto.failed("标题或url已经存在");
        }



    }

    @Override
    public UniversalityDto updateFriendshipLink(int id, String title, String lastTitle, String url) {


        //判断新标题是否已存在
        if(!title.equals(lastTitle)){
            BlogrollExample example=new BlogrollExample();
            BlogrollExample.Criteria criteria = example.createCriteria();
            criteria.andTitleEqualTo(title);
            criteria.andBlogrollIdNotEqualTo(id);
            List<Blogroll> blogrolls = blogrollMapper.selectByExample(example);

            if(blogrolls.size()>0){
                return  UniversalityDto.failed("新标题已存在");
            }

        }

        Blogroll blogroll=new Blogroll();
        blogroll.setBlogrollId(id);
        blogroll.setUrl(url);
        blogroll.setTitle(title);

        int i = blogrollMapper.updateByPrimaryKeySelective(blogroll);


        if(i>0){
            return  UniversalityDto.success(null);
        }else{
            return  UniversalityDto.failed();
        }


    }

    @Override
    public UniversalityDto delFriendshipLink(int id) {

        int i = blogrollMapper.deleteByPrimaryKey(id);

        if(i>0){
            return  UniversalityDto.success(null);
        }else{
            return  UniversalityDto.failed();
        }

    }
}

package com.www.acorn.mapper;

import com.www.acorn.dto.CircleAndAttentionNumDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface MyCircleMapper {

// [{
//        ciecle_id:v, //circle表
//                user_id:v,
//                name:v,
//                intro:v,
//                icon:v,  // 为圈子表新增字段
//                date:v,
//                limit_post_flag:v,
//                current_limit_flag:v,
//                excellent_flag:v,
//                admin_flag:v,
//                // 关注人数
//                attention_num:v, //circle_attention表
//                // 圈子标签
//                tags:[
//        {
            //            tag_id:v, //tag表
            //            title:v,
            //             time:v
//        }
//    ]
//    }]


    @Select("</script> select " +
            " circle.*," +
            " (select count(1)  from  circle_attention  where ciecle_id=circle.ciecle_id) as attention_num " +
            " from  circle " +
            " <if test='userId != null || userId!= &apos;&apos;'>  where user_id=#{userId} </if>" +
            " </script>")
    List<Map> findUserAttentionCircle(@Param("userId")String userId);

    @Select(" select tag.*  from  circle_tag left join tag  on circle_tag.tag_id=tag.tag_id where ciecle_id=#{ciecleId}")
    List<Map> findUserCircleTag(@Param("ciecleId")String ciecleId);


    List<CircleAndAttentionNumDto> selectRecommendCircle();

    List<CircleAndAttentionNumDto>  selectOfficialCircle();

    List<CircleAndAttentionNumDto> selectSearchCircle(@Param("searchText")String searchText);

    List<CircleAndAttentionNumDto> selectAllCircle();



}

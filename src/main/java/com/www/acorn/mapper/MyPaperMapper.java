package com.www.acorn.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MyPaperMapper {

     List<Map> selectPostPaper(@Param("userId") int userId);

     List<Map> selectDraftPaper(@Param("userId") int userId);

     List<Map> selectCollectPaper(@Param("userId") int userId,@Param("paperId") int paperId);

    List<Map> selectRecyclePaper(@Param("userId") int userId);

    List<Map> selectPaperDetail(@Param("paperId") int paperId);

//    int updateMoveToDraftPaper(@Param("userId") int userId,@Param("paperId") int paperId);

//    delPaper(@Param("paperId") int paperId);
//
//    updateRemoveRecycle(@Param("paperId") int paperId);
//
//    updateRemoveCollect(@Param("userId") int userId);
//
//    insertCreatePaper();



}

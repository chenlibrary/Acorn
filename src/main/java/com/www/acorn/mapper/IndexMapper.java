package com.www.acorn.mapper;


import com.www.acorn.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IndexMapper {


    @Select("select * from user")
    List<User> findIndex();
}

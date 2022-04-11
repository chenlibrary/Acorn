package com.www.acorn.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;


@Data
public class CircleDtoRequest implements Serializable {


//    name	string	圈子标题
//    icon	string	圈子封面图片地址
//    intro	string	简介
//    tagLs	array	圈子标签
//    adminFlag	boolean	官方圈子标记（存在则为官方圈子，反之不是）
    @NotBlank(message = "圈子标题不能为空！")
    private String name;//圈子标题
    @NotBlank(message = "圈子封面图片地址不能为空！")
    private String icon;//圈子封面图片地址
    @NotBlank(message = "简介不能为空！")
    private String intro;//简介
    @NotEmpty(message = "圈子标签不能为空！")
    private List<String> tagLs; //圈子标签
    @NotBlank(message = " 官方圈子标记不能为空！")
    private String adminFlag; // 官方圈子标记（存在则为官方圈子，反之不是）



}

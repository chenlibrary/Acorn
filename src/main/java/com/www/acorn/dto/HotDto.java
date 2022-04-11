package com.www.acorn.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;


@Data
@EqualsAndHashCode(callSuper = true)
public class HotDto extends  PageDto{

//    @NotBlank(message = "页码不能为空！")
//    private int page;
//    @NotBlank(message = "分页数量不能为空！")
//    private int num;
    @NotBlank(message = "排序方式不能为空！")
    private String type;
    @NotBlank(message = "当前时间！")
    private String time;

}

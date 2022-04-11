package com.www.acorn.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class PageDto {
    @NotBlank(message = "页码不能为空！")
    private int page;
    @NotBlank(message = "分页数量不能为空！")
    private int num;
}

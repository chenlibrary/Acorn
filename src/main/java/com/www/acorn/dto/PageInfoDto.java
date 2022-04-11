package com.www.acorn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoDto {
    private Integer totalPage;
    private List<Map> ls;


}

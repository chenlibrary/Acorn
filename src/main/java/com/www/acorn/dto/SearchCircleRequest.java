package com.www.acorn.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper=true)
public class SearchCircleRequest extends PageDto implements Serializable {

    /**
     * 搜索字段
     */
    private String searchText;

}

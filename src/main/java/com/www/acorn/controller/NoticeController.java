package com.www.acorn.controller;

import com.www.acorn.dto.HotDto;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/notice" )
    public Object notice(@RequestBody @Validated HotDto hotDto){


        UniversalityDto universalityDto = noticeService.noticePage(hotDto);


        return universalityDto;
    }


}

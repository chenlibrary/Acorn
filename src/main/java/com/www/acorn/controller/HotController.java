package com.www.acorn.controller;

import com.www.acorn.dto.HotDto;
import com.www.acorn.dto.UniversalityDto;
import com.www.acorn.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin()
public class HotController {

    @Autowired
    private HotService hotService;

    @RequestMapping(value = "/hot" )
    public Object hot(@RequestBody @Validated HotDto hotDto){


        UniversalityDto universalityDto = hotService.hotPage(hotDto);


        return universalityDto;
    }
}

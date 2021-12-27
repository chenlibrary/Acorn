package com.www.acorn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class AcornApplicationTests {

    @Test
    void contextLoads() {
        Map<String,String> m=new HashMap<String,String>();

        m.put("A","a");
        m.put("B","b");
        m.put("C","c");

        List<Map> l=new ArrayList<Map>();
        ResponseEntity responseEntity = new ResponseEntity(l, HttpStatus.OK);


        System.out.println(responseEntity.toString());

    }

}

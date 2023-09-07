package com.example.demo.controller;

import com.elites.center.product.domain.CenterCountry;
import com.elites.center.product.domain.CenterProductTag;
import com.elites.center.product.mapper.CenterCountryMapper;
import com.elites.center.product.mapper.CenterProductTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private CenterProductTagMapper centerProductTagMapper;

    @Autowired
    private CenterCountryMapper countryMapper;

    @PostMapping("/test/a")
    public String test(CenterCountry country){
        int i = countryMapper.insert(country);
        return i==0?"失败":"成功";
    }

    @PostMapping("/test/b")
    public String test(Integer id){
        CenterCountry centerCountry = countryMapper.selectByPrimaryKey(id);
        return centerCountry==null?"失败":"成功";
    }

//    @GetMapping("/test/b")
//    pubZlic String test1(){
//        List<CenterProductTag> list = centerProductTagMapper.listCenterProductTagByProductId(1L);
//        return list.toString();
//    }


    @GetMapping("/get")
    public Stu getStu(){
        Stu s = new Stu();
        s.setName("zhp");
        s.setTime(new Date());
        s.setTimeStr("qwe");
        return s;
    }
    @GetMapping("/get01")
    public Stu getStu01(){
        Stu s = new Stu();
        s.setName("zhp");
        s.setTime(new Date());
        return s;
    }

    @PostMapping("/add")
    public Stu add(@RequestBody Stu s){
        System.out.println(s);
        System.out.println(s.getTimeStr());
        return s;
    }

}

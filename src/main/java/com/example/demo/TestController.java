package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/a")
    public String test(){
        if (true) {
            throw new RuntimeException("test");
        }
        return "testa";
    }

    @GetMapping("/test/b")
    public String test1(){
        return "test B";
    }


    @GetMapping("/test")
    public String test2(){
        return "Test test";
    }

}

package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@RestController
class hello {
    @RequestMapping("/just")
    public String just(){
        return "just";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
@Controller
class testdemo{
    @RequestMapping("/demo")
    public String ttt(){return "test25";}
}
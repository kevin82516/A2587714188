package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
class HtmlController {
    @RequestMapping("/html")
    public String html() {
        return "indexs";
    }
    @RequestMapping("/testmysql")
    public String test() {
        return "testmysql";
    }
}
@Controller
@RequestMapping("/mysql")
class mysql{

}
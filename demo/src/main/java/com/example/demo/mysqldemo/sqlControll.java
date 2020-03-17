package com.example.demo.mysqldemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class mysqldemo {
    @ResponseBody
    @RequestMapping("/mysql")
    public String mysql() {
        DBConnect connection=new DBConnect();
        return String.valueOf(connection.getData());
    }
}

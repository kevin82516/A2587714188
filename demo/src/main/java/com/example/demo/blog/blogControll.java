package com.example.demo.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class blogControll {
    @RequestMapping("/")
    public ModelAndView blogHome(){
        ModelAndView mv = new ModelAndView("bloghome");
        return mv;
    }

}

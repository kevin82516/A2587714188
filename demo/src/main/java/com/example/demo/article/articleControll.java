package com.example.demo.article;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class articleControll {
    @RequestMapping("/article")
    public ModelAndView articleHome(){
        ModelAndView mv = new ModelAndView("articleindex");
        return mv;
    }

}
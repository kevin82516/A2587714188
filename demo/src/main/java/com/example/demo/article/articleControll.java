package com.example.demo.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.articlemodels.articleRepo;
import com.example.demo.articlemodels.articledata;
@Controller
public class articleControll {


    @Autowired
    articleRepo artRepo;

    //更新資料方法
    @RequestMapping( value = "article/updata", method = RequestMethod.POST)
    public ModelAndView artSave(@RequestParam("id") int id, @RequestParam("title") String title,
                               @RequestParam("content") String content ){
        ModelAndView mv = new ModelAndView("redirect:/article");
        articledata article = new articledata();
        article.setId(id);
        article.settitle(title);
        article.setcontent(content);
        artRepo.save(article);
        return mv;
    }
    //創建新資料方法
    @RequestMapping( value = "article/add", method = RequestMethod.POST)
    public ModelAndView artCreat(@RequestParam("id") int id, @RequestParam("title") String title,
                                @RequestParam("content") String content ){
        ModelAndView mv = new ModelAndView("redirect:/article");
        mv.addObject("lists",artRepo.findAll());
        articledata article = new articledata();
        article.settitle(title);
        article.setcontent(content);
        artRepo.save(article);
        return mv;
    }

    @RequestMapping("/article")
    public ModelAndView articleHome(){
        ModelAndView mv = new ModelAndView("articleindex");
        mv.addObject("article",artRepo.findAll());
        return mv;
    }

    //顯示單一資料
    @RequestMapping( value = "article/view/{id}", method = RequestMethod.GET)
    public ModelAndView artView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("articleview");
        mv.addObject("article", artRepo.findById(id).get());
        return mv;
    }
    // 創建資料
    @RequestMapping( value = "article/create", method = RequestMethod.GET)
    public ModelAndView artadd(){
        ModelAndView mv = new ModelAndView("articleadd");
        return mv;
    }
    //刪除資料
    @RequestMapping( value = "article/delete/{id}", method = RequestMethod.GET)
    public ModelAndView artDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/article");
        artRepo.deleteById(id);
        return mv;
    }
    //編輯資料
    @RequestMapping( value = "article/edit/{id}", method = RequestMethod.GET)
    public ModelAndView artEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("articleedit");
        mv.addObject("lists",artRepo.findById(id));
        return mv;
    }
}
package com.example.demo.article;

import org.springframework.beans.factory.annotation.Value;
import com.example.demo.articlemodels.articleRepo;
import com.example.demo.articlemodels.articledata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Controller
public class articleControll {


    @Autowired
    articleRepo artRepo;

    //更新資料方法
    @RequestMapping( value = "article/updata", method = RequestMethod.POST)
    public ModelAndView artSave(@RequestParam("id") int id, @RequestParam("title") String title,
                               @RequestParam("content") String content,@RequestParam("image") MultipartFile file){
        ModelAndView mv = new ModelAndView("redirect:/article");
        articledata article = new articledata();
        article.setId(id);
        article.settitle(title);
        article.setcontent(content);
        article.setimage(file.getOriginalFilename());
        artRepo.save(article);
        return mv;
    }

    //創建新資料方法
    @Value("${filePath}")
    private String filePath;
    @RequestMapping( value = "article/add", method = RequestMethod.POST)
    public ModelAndView artCreat(@RequestParam("id") int id, @RequestParam("title") String title,
                                @RequestParam("content") String content,@RequestParam("image") MultipartFile file){
        ModelAndView mv = new ModelAndView("redirect:/article");
        mv.addObject("lists",artRepo.findAll());
        articledata article = new articledata();
        article.settitle(title);
        article.setcontent(content);
        article.setimage(file.getOriginalFilename());
        try {
            uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上傳失敗!");
        }
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
    @RequestMapping( value = "article/{id}", method = RequestMethod.GET)
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

    public void  uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}

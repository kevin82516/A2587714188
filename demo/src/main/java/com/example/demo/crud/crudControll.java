package com.example.demo.crud;

import com.example.demo.models.AppUserRepo;
import com.example.demo.models.AppUsers;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;


@Controller
public class crudControll {


    @Autowired
    AppUserRepo appRepo;


    @RequestMapping("/crud")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("crudindex");
        mv.addObject("lists",appRepo.findAll());

        return mv;
    }
    @RequestMapping( value = "/updata", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") int id, @RequestParam("firstname") String firstName,
                               @RequestParam("lastname") String lastName ,@RequestParam("age") String Age,
                               @RequestParam("height") String Height,@RequestParam("weight") String Weight,
                               @RequestParam("job") String Job,@RequestParam("interest") String Interest){
        ModelAndView mv = new ModelAndView("redirect:/crud");
        AppUsers users = new AppUsers();
        users.setId(id);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setAge(Age);
        users.setHeight(Height);
        users.setWeight(Weight);
        users.setJob(Job);
        users.setInterest(Interest);
        appRepo.save(users);
        return mv;
    }
    @RequestMapping( value = "/create", method = RequestMethod.POST)
    public ModelAndView doCreat(@RequestParam("id") int id, @RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName ,@RequestParam("age") String Age,
                                @RequestParam("height") String Height,@RequestParam("weight") String Weight,
                                @RequestParam("job") String Job,@RequestParam("interest") String Interest){
        ModelAndView mv = new ModelAndView("redirect:/crud");
        mv.addObject("lists",appRepo.findAll());
        AppUsers users=new AppUsers();
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setAge(Age);
        users.setHeight(Height);
        users.setWeight(Weight);
        users.setJob(Job);
        users.setInterest(Interest);
        appRepo.save(users);
        return mv;
    }


    @RequestMapping( value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("crudviews");
        mv.addObject("lists", appRepo.findById(id).get());
        return mv;
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/crud");
        appRepo.deleteById(id);
        return mv;
    }

    @RequestMapping( value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("crudedit");
        mv.addObject("lists",appRepo.findById(id));
        return mv;
    }
    @Value("${filePath}")
    private String filePath;
    @RequestMapping( value = "/inputfile", method = RequestMethod.POST)
    public ModelAndView dofile(@RequestParam("file") MultipartFile file){
        ModelAndView mv = new ModelAndView("redirect:/crud");
        try {
            uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上傳失敗!");
        }
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




package com.example.demo.crud;

import com.example.demo.models.AppUserRepo;
import com.example.demo.models.AppUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class crudControll {


    @Autowired
    AppUserRepo appRepo;


    @RequestMapping("/crud")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("crudindex");
        mv.addObject("lists",appRepo.findAll());
        Optional<AppUsers> test = appRepo.findById(2);
        System.out.println(test);
        System.out.println();
        return mv;
    }
    @RequestMapping( value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") int id, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName){
        ModelAndView mv = new ModelAndView("redirect:/crud");
//        AppUsers users;
//        if(!id.isEmpty()){
//            users =(AppUsers)appRepo.findById(id));
//        } else {
        AppUsers users = new AppUsers();
//        }
        users.setId(2);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        appRepo.save(users);
        return mv;
    }

    @RequestMapping( value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("crudviews");
        mv.addObject("lists",appRepo.findById(id));
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

}



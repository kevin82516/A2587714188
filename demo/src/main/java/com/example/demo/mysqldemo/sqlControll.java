//package com.example.demo.mysqldemo;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMethod;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.ui.Model;
//import java.util.Date;
//import lombok.Data;
//import lombok.AllArgsConstructor;
//
//
//@Controller
//@RequestMapping("/mysql")
//class mysqldemo {
//    @RequestMapping(value = "home")
//    public String mysqlhome() {
//        String db;
//        DBConnect connection=new DBConnect();
//        db=String.valueOf(connection.getData());
//        return "mysqlhome";
//    }
//
//    @RequestMapping(value = "Create")
//    public String mysqlCreate() {
//        return "mysqlCreate";
//    }
//
//    @RequestMapping(value = "Add")
//    public String mysqlAdd() {
//        return "mysqlAdd";
//    }
//
//    @RequestMapping(value = "Updata")
//    public String mysqlUpdata() {
//        return "mysqlUpdata";
//    }
//
//    @RequestMapping(value = "Delet")
//    public String mysqlDelet() {
//        return "mysqlDelet";
//    }
//
////    @RequestMapping(value = "just" ,method = RequestMethod.GET)
////    public String just() {
////        DBConnect connection=new DBConnect();
////        List<String> db=new ArrayList<>();
////        db=connection.getData();
////        String test=db.get(1);
////        return "mysqlhome";
////    }
//@GetMapping("/test")
//
//public ModelAndView test(Model model){
//    ModelAndView modelAndView = new ModelAndView("mysqlAdd");
//    DBConnect connection=new DBConnect();
//    modelAndView.addObject("DB",connection.getData());
//
//    return modelAndView;
//}
//    @GetMapping("/index")
//
//    public ModelAndView index(Model model){
//        ModelAndView modelAndView = new ModelAndView("mysqlhome");
//
//        List<Fans> fans = new ArrayList<>();
//        fans.add(new Fans(1L, "zhangsan"));
//        fans.add(new Fans(2L, "lis"));
//        fans.add(new Fans(3L, "wangwu"));
//
//        modelAndView.addObject("user", new User(1L, "mengday", "xxx@gmail.com", fans, true, new Date()));
//
//        return modelAndView;
//    }
//    @Data
//    @AllArgsConstructor
//    public class User {
//        private Long id;
//        private String username;
//        private String email;
//        private List<Fans> fans;
//        private Boolean isAdmin;
//        private Date birthday;
//    }
//
//    @Data
//    @AllArgsConstructor
//    public class Fans {
//        private Long id;
//        private String name;
//    }
//}
//

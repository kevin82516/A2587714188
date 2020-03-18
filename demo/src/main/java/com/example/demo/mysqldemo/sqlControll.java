package com.example.demo.mysqldemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mysql")
class mysqldemo {
    @RequestMapping(value = "home")
    public String mysqlhome() {
        String db;
        DBConnect connection=new DBConnect();
        db=String.valueOf(connection.getData());
        return "mysqlhome";
    }

    @RequestMapping(value = "Create")
    public String mysqlCreate() {
        return "mysqlCreate";
    }

    @RequestMapping(value = "Add")
    public String mysqlAdd() {
        return "mysqlAdd";
    }

    @RequestMapping(value = "Updata")
    public String mysqlUpdata() {
        return "mysqlUpdata";
    }

    @RequestMapping(value = "Delet")
    public String mysqlDelet() {
        return "mysqlDelet";
    }
}

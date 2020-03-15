package com.example.demo.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DB.*;

@RestController
@RequestMapping("/DBtest")
class BDController {
    @Autowired
    myDB db1;

}

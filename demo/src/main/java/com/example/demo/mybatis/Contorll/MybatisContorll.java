package com.example.demo.mybatis.Contorll;

import com.example.demo.mybatis.mapper.UserMapper;
import com.example.demo.mybatis.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.mybatis.mapper.cocoMapper;
import com.example.demo.mybatis.models.coco;
import com.example.demo.mybatis.mapper.testMapper;
import com.example.demo.mybatis.models.test;

import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MybatisContorll {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private cocoMapper cocoMapper;
    @Autowired
    private testMapper testMapper;

    @GetMapping ("user")
    public List<user> getuserinfo(){
        List<user> userlist=userMapper.selectList(null);
        return userlist;
    }

    @GetMapping ("coco")
    public List<coco> getcocoinfo(){
        List<coco> cocolist=cocoMapper.selectList(null);
        return cocolist;
    }

    @GetMapping ("test")
    public List<test> gettestinfo(){
        List<test> testlist0 =testMapper.fllowtime("Tom","0");
        System.out.println(testlist0);
        List<test> testlist1 =testMapper.fllowtime("Tom","1");
        System.out.println(testlist1);
        return testlist1;
    }

}


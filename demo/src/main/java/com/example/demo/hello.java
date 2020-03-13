package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class hello {
    @RequestMapping("/just")
    public String just(){
        return "just";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}

@RestController
class MemberApiController {
    @Autowired
    MemberAccount memberAccount;
    @RequestMapping("/memberApi/memberTest")
    public MemberAccount memberTest() {
        MemberAccount memberAccount = new MemberAccount();
        memberAccount.setAddress("台北市");
        memberAccount.setCellphone("09123456789");
        memberAccount.setEmail("test@gmail.com");
        memberAccount.setId(1);
        memberAccount.setPassword("123456789");
        return memberAccount;
    }
}
@RestController
class productControll{
@GetMapping(value = "/products/{id}")
    public String getProduct(@PathVariable("id") String id) {
        Product product = new Product();
        product.setId(id);
        return "Horror Movie Episode " + id;
    }
}

class Product{
    String id;
    String setId(String id){
        this.id=id;
        return id;
    }
}





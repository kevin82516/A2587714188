package com.example.demo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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





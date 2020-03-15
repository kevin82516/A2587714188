package com.example.demo.DB;

import org.springframework.stereotype.Component;


@Component
class myDB{
    private String id;
    private String gameid;
    public String setid(String id){
        this.id=id;
        return this.id;
    }
    public String setgameid(String gameid){
        this.gameid=gameid;
        return this.gameid;
    }
}
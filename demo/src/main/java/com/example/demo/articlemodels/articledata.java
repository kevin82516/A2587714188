//package com.example.demo.articlemodels;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "article")
//public class articledata {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int id;
//    @Column(name = "title")
//    public String title;
//    @Column(name = "content")
//    public String content;
//    public articledata() {
//    }
//
//    public articledata(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String gettitle() {
//        return title;
//    }
//
//    public void settitle(String title) {
//        this.title = title;
//    }
//
//    public String getcontent() {
//        return content;
//    }
//
//    public void setcontent(String content) {
//        this.content = content;
//    }
//
//}
package com.example.demo.articlemodels;

import javax.persistence.*;

@Entity
@Table(name = "article2")
public class articledata {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    public int Artid;
    @Column(name = "title")
    public String title;
    @Column(name = "content")
    public String content;
    @Column(name = "image")
    public String image;
    public articledata() {
    }

    public articledata(String title, String content,String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public int getId() {
        return Artid;
    }

    public void setId(int id) {
        this.Artid = id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }
}
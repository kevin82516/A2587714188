package com.example.demo.crud;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
//
//
//@Entity
//@Table(name="T_USER")

class User {
    /**
     * 使用者ID
     */
    @Id
//    @GeneratedValue
    private int id;
    /**
     * 使用者名稱
     */
    private String name;
// GETTER和SETTER此處省略...
}
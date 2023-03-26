package com.springboot.adminex.controller;

import com.springboot.adminex.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//测试Profile功能
@RestController
public class PersonController {
    @Autowired
    private Person person;

    @RequestMapping("/person")
    public String person() {
        return person.toString();
    }
}

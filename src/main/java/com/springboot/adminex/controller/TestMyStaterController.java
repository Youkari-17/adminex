package com.springboot.adminex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_custom.service.MyService;

@RestController
public class TestMyStaterController {
    @Autowired
    private MyService myService;

    @GetMapping("/custom-stater")
    public String testMyStater() {
        return myService.sayHi("ok");
    }
}

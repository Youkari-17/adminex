package com.springboot.adminex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.springboot.adminex.servlet")//指定原生Servlet组件
public class AdminExApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminExApplication.class, args);
    }

}

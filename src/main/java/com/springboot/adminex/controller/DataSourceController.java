package com.springboot.adminex.controller;

import com.springboot.adminex.bean.Emp;

import com.springboot.adminex.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataSourceController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmpService empService;

    @RequestMapping("/sql")
    @ResponseBody
    public String sqlTest() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_emp", Long.class);
        return aLong.toString();
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Emp selectEmpById(@PathVariable("id") Integer id) {
        return empService.getById(id);
    }
}

package com.springboot.adminex.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.adminex.bean.Emp;
import com.springboot.adminex.bean.User;
import com.springboot.adminex.exception.TooManyUserException;
import com.springboot.adminex.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/basic_table")
    public String basicTable() {
        return "table/basic_table";
    }

    @RequestMapping("/dynamic_table/{page_number}")
    public String dynamicTable(@PathVariable(value = "page_number", required = false) Integer pageNumber, Model model, HttpSession session) {
        List<User> users = Arrays.asList((User) session.getAttribute("loginUser"), new User("张三", "123456"),
                new User("lisi", "123456"),
                new User("王五", "aaaaaa"),
                new User("赵六", "asdfgh"));
        model.addAttribute("users", users);
        if (users.size() > 10) {
            //测试@ResponseStatus+自定义异常
            throw new TooManyUserException();
        }
        //测试分页和CRUD
        if (pageNumber == null) {
            pageNumber = 1;
        }
        Page<Emp> page = new Page<>(pageNumber, 2);
        IPage<Emp> empPage = empService.page(page, null);
        model.addAttribute("empPage", empPage);
        return "table/dynamic_table";
    }

    @GetMapping("/dynamic_table/delete/{id}")
    public String deleteEmpById(@PathVariable("id") Integer id,
                                @RequestParam(value = "pageNumber", defaultValue = "1")
                                        Integer pageNumber) {
        empService.removeById(id);
        return "redirect:/dynamic_table/" + pageNumber;
    }

    @RequestMapping("/editable_table")
    public String editableTable() {
        return "table/editable_table";
    }

    @RequestMapping("/responsive_table")
    public String responsiveTable() {
        return "table/responsive_table";
    }
}

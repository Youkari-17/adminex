package com.springboot.adminex.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.adminex.bean.Emp;
import com.springboot.adminex.mapper.EmpMapper;
import com.springboot.adminex.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper,Emp> implements EmpService {
//    @Autowired
//    private EmpMapper empMapper;
//
//    public Emp selectEmpById(Integer id) {
//        return empMapper.selectEmpById(id);
//    }
}

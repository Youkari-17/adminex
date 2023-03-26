package com.springboot.adminex.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.adminex.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
}

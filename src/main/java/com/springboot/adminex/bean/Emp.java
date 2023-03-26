package com.springboot.adminex.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_emp")
public class Emp {
    @TableId
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Integer did;
}

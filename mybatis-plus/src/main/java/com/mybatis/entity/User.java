package com.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user_info")
public class User {

    @TableId(value = "id")
    private Integer id;

    private String name;

    private Integer age;

    private String department;

    private Double salary;


}

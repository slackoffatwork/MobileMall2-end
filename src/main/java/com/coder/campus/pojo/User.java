package com.coder.campus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@TableName(value ="tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String name;
    private String password;
    private String verifiCode;
    private Integer userType;

    private List<Class> aClass;
    private List<Role> roles;
    private List<Menu> menus;
    private Menu menuTree;
}

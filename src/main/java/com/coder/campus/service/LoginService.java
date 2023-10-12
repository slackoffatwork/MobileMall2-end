package com.coder.campus.service;

import com.coder.campus.pojo.LoginForm;
import com.coder.campus.pojo.Menu;
import com.coder.campus.pojo.User;
import com.coder.campus.utils.ResultDTO;

import java.util.List;


public interface LoginService{
    ResultDTO login(String name, String password);

    List<Menu> getMenuList(List<Menu> menus);

    User doLogin(User user);


}

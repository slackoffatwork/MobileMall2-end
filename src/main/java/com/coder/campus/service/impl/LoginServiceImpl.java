package com.coder.campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.campus.mapper.AdminMapper;
import com.coder.campus.mapper.LoginMapper;
import com.coder.campus.pojo.Admin;
import com.coder.campus.pojo.LoginForm;
import com.coder.campus.pojo.Menu;
import com.coder.campus.pojo.User;
import com.coder.campus.service.AdminService;
import com.coder.campus.service.LoginService;
import com.coder.campus.utils.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * 登录服务
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public ResultDTO login(String name, String password) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return ResultDTO.errorOf(400, "用户名或密码不能为空");
        }
//        User user = loginMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, name).eq(User::getPassword, password));
        User user = loginMapper.login(name, password);
        if (user == null) {
            return ResultDTO.errorOf(400, "用户名或密码错误");
        }
        return ResultDTO.okOf(user);
    }

    @Override
    public List<Menu> getMenuList(List<Menu> menus) {
        LinkedList<Menu> queue = new LinkedList<>(menus);
        List<Menu> tree = new ArrayList<>();
        Map<Integer,Menu> menuMap = menus.stream().collect(Collectors.toMap(Menu::getId, node -> node));
        while (!queue.isEmpty()){
            Menu menu = queue.poll();
            if ( menu.getFId() == null || menu.getFId() == 0 ){
                tree.add(menu);
            }else {
                Menu fMenu = menuMap.get(menu.getFId());
                if (fMenu.getChild() == null){
                    List<Menu> child = new ArrayList<>();
                    fMenu.setChild(child);
                }
                fMenu.getChild().add(menu);
            }
        }
        return tree;
    }

    @Override
    public User doLogin(User user) {
        User userInfo = loginMapper.queryUserInfo(user.getUserId());
        List<Menu> menuList = getMenuList(userInfo.getMenus());
        userInfo.setMenuTree(menuList.get(0));
        return userInfo;
    }

}





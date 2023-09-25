package com.coder.campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.campus.mapper.AdminMapper;
import com.coder.campus.mapper.LoginMapper;
import com.coder.campus.pojo.Admin;
import com.coder.campus.pojo.User;
import com.coder.campus.service.AdminService;
import com.coder.campus.service.LoginService;
import com.coder.campus.utils.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        User user = loginMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, name).eq(User::getPassword, password));
        if (user == null) {
            return ResultDTO.errorOf(400, "用户名或密码错误");
        }
        return ResultDTO.okOf(user);
    }
}





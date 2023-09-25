package com.coder.campus.service.impl;

import com.coder.campus.mapper.AdminMapper;
import com.coder.campus.mapper.LoginMapper;
import com.coder.campus.pojo.Admin;
import com.coder.campus.pojo.User;
import com.coder.campus.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ziqiu
* @description 针对表【tb_admin】的数据库操作Service实现
* @createDate 2023-02-04 16:09:29
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void add(Admin admin) {
        if (admin.getId() != null && admin.getId() != 0){
            adminMapper.update(admin);
        }else {
            adminMapper.add(admin);
        }
    }

    @Override
    public void delete(int id) {
        adminMapper.delete(id);
    }

    @Override
    public List<Admin> queryall() {
        return adminMapper.queryall();
    }

    @Override
    public Admin queryById(int id) {
        return adminMapper.queryById(id);
    }

    @Override
    public User queryUser(String name, String password) {
        return loginMapper.login(name,password);
    }


}





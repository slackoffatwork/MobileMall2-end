package com.coder.campus.service;

import com.coder.campus.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coder.campus.pojo.User;

import java.util.List;

/**
* @author ziqiu
* @description 针对表【tb_admin】的数据库操作Service
* @createDate 2023-02-04 16:09:29
*/
public interface AdminService extends IService<Admin> {
    void add(Admin admin);

    void delete(int id);

    List<Admin> queryall();

    Admin queryById(int id);

    User queryUser(String name, String password);

}

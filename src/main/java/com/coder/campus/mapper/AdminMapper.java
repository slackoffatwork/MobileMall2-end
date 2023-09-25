package com.coder.campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coder.campus.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author ziqiu
* @description 针对表【tb_admin】的数据库操作Mapper
* @createDate 2023-02-04 16:09:29
* @Entity com.atguigu.campus.pojo.Admin
*/
@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    void add(Admin admin);

    void delete(int id);

    void update(Admin admin);

    List<Admin> queryall();

    Admin queryById(int id);
}





package com.coder.campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coder.campus.pojo.User;
import com.coder.campus.utils.ResultDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<User> {
        User login(String name, String password);
}

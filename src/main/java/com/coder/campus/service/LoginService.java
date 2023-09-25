package com.coder.campus.service;

import com.coder.campus.utils.ResultDTO;


public interface LoginService{
    ResultDTO login(String name, String password);
}

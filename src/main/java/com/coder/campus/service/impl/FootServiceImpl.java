package com.coder.campus.service.impl;

import com.coder.campus.mapper.GoodsMapper;
import com.coder.campus.pojo.Goods;
import com.coder.campus.service.FootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class FootServiceImpl implements FootService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public LinkedList<Goods> BHistory(int id) {

        return null;
    }
}

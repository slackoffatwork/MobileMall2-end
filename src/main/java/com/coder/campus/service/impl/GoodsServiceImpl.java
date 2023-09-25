package com.coder.campus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.campus.mapper.GoodsMapper;
import com.coder.campus.pojo.Goods;
import com.coder.campus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int add(Goods goods) {
        return goodsMapper.add(goods);
    }

    @Override
    public int delete(Integer id) {
        return goodsMapper.delete(id);
    }

    @Override
    public Goods update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public List<Goods> queryall() {
        List<Goods> goods = goodsMapper.queryAll();
        return goods;
    }

    @Override
    public Goods queryById(Goods goods) {
        return goodsMapper.queryById(goods);
    }

    @Override
    public List<Goods> queryByIds(int[] ids) {
        return goodsMapper.queryByIds(ids);
    }

    @Override
    public List<Goods> addBatch(List<Goods> goodsList) {
        return goodsMapper.addBatch(goodsList);
    }

    @Override
    public List<Goods> batchModifyGoods(List<Goods> goodsList) {
        return goodsMapper.batchModifyGoods(goodsList);
    }

    @Override
    public int batchDeleteGoods(int[] ids) {
        return goodsMapper.batchDeleteGoods(ids);

    }

    @Override
    public Page<Goods> queryByPage(Page<Goods> page) {
        return goodsMapper.queryByPage(page);
    }


}

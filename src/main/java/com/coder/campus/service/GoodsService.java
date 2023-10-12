package com.coder.campus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.campus.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
//    增删改查
    int add(Goods goods);

    int delete(Integer id);

    Goods update(Goods goods);

    List<Goods> queryall();

    Goods queryById(Integer id);
    List<Goods> queryByIds(int[] ids);

    List<Goods> addBatch(List<Goods> goodsList);

    List<Goods> batchModifyGoods(List<Goods> goodsList);
//        批量删除
    int batchDeleteGoods(int[] ids);

    Page<Goods> queryByPage(Page<Goods> page);

}

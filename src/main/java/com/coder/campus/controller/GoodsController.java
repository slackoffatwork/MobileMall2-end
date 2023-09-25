package com.coder.campus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.campus.mapper.GoodsMapper;
import com.coder.campus.pojo.Goods;
import com.coder.campus.service.GoodsService;
import com.coder.campus.utils.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * 商品管理
 *
 */
@Api(tags = "商品管理")
@RestController
//单个接口跨域
//@CrossOrigin
@RequestMapping("/sc/goodsController")
public class GoodsController {
    //    restful风格  get 查 post 添加 put 修改 delete 删除
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;
//    添加
    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultDTO<Integer> addGood( Goods good){
        int add = goodsService.add(good);
        return ResultDTO.okOf(add);
    }

// 查询

    @ApiOperation("查询")
    @GetMapping("/goodsList")
    public ResultDTO<List<Goods>> goodsList(){
        List<Goods> queryall = goodsService.queryall();
        return ResultDTO.okOf(queryall);
    }
// 根据id进行查询
    @ApiOperation("根据id查询")
    @GetMapping("/good")
    public ResultDTO<Goods> good(Goods goods, HttpServletRequest request){
        Goods goods1 = goodsService.queryById(goods);
        //        将商品id存到session中
        HttpSession session = request.getSession();
        session.setAttribute("good",goods1);
        return ResultDTO.okOf(goods);
    }
// 删
    @ApiOperation("删除")
    @GetMapping("/deleteGoods/{id}")
    public ResultDTO<Integer> deleteGood(@PathVariable("id") Integer id){
        int delete = goodsService.delete(id);
        return ResultDTO.okOf(delete);
    }

// 改
    @ApiOperation("修改")
    @PostMapping("/updateGood")
    public ResultDTO<Goods> updataGood(Goods good){
        Goods update = goodsService.update(good);
        return ResultDTO.okOf(update);

    }
    @ApiOperation("根据id批量查询")
    @GetMapping("/queryByIds")
    public ResultDTO<List<Goods>> queryByIds(int[] ids){
        List<Goods> goodsList = goodsService.queryByIds(ids);
        return ResultDTO.okOf(goodsList);
    }

    @ApiOperation("批量插入")
    @PostMapping("/addBatch")
    public List<Goods> addBatch(@Param("list") List<Goods> goodsList){
        return goodsService.addBatch(goodsList);
    }

    @ApiOperation("批量更新")
    @PostMapping("/updateBatch")
    public ResultDTO<List<Goods>> updateBatch(List<Goods> goodsList){
        List<Goods> goods = goodsService.batchModifyGoods(goodsList);
        return ResultDTO.okOf(goods);
    }

    @ApiOperation("根据id批量删除")
    @GetMapping("/deleteBatch")
    public ResultDTO<Integer> deleteBatch(int[] ids){
        int i = goodsService.batchDeleteGoods(ids);
        return ResultDTO.okOf(i);
    }

    @ApiOperation("分页查询")
    @GetMapping("/queryBy/{pageNum}/{pageSize}")
    public ResultDTO queryByPage(@PathVariable("pageNum") Integer pageNum,
                                 @PathVariable("pageSize") Integer pageSize){
        Page<Goods> page = new Page<>(pageNum, pageSize);
        Page<Goods> goodsPage = goodsService.queryByPage(page);
        return ResultDTO.okOf(goodsPage);
    }

    @ApiOperation("分页查询limit")
    @GetMapping("/queryBy2/{pageNum}/{pageSize}")
    public ResultDTO queryByPageLimit(@PathVariable("pageNum") Integer pageNum,
                                 @PathVariable("pageSize") Integer pageSize){
        List<Goods> goodsList = goodsMapper.queryGoodsByPage(pageNum, pageSize);
        return ResultDTO.okOf(goodsList);
    }
}

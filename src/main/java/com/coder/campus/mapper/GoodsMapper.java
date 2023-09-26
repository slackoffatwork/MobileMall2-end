package com.coder.campus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.campus.pojo.Goods;
import com.coder.campus.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface GoodsMapper {
    @Insert("insert into tb_goods (name,price,description,img,createtime) values (#{name},#{price},#{description},#{img},#{createtime})")
    int add(Goods goods);
    @Delete("delete from tb_goods where id = #{id};")
    int delete(Integer id);
    @Update("update tb_goods set name=#{name},price=#{price},description=#{description},img=#{img},createtime=#{createtime} where id = #{id};")
    Goods update(Goods goods);
    @Select("select * from tb_goods;")
    List<Goods> queryAll();

    Goods queryById(Goods goods);

//   批量查询
    List<Goods> queryByIds(int[] ids);
//    批量插入
    List<Goods> addBatch(List<Goods> goodsList);
//    批量更新
    List<Goods> batchModifyGoods(List<Goods> goodsList);
//    批量删除
    int batchDeleteGoods(int[] ids);
// 分页查询
    List<Goods> queryGoodsByPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
//    使用mybatisPlus插件
    Page<Goods> queryByPage(Page<Goods> page);

//    连表查询
    Class query(Integer id);
}

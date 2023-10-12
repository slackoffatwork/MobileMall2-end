package com.coder.campus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.campus.pojo.Goods;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface GoodsMapper {
    @Insert("insert into tb_goods (name,price,originalPrice,description,img,createtime,num,tag) values (#{name},#{originalPrice},#{price},#{description},#{img},#{createtime},#{num},#{tag})")
    int add(Goods goods);
    @Delete("delete from tb_goods where good_id = #{good_id};")
    int delete(Integer id);
    @Update("update tb_goods set name=#{name},price=#{price},originalPrice=#{originalPrice},description=#{description},img=#{img},createtime=#{createtime},num=#{num},tag=#{tag} where good_id = #{good_id};")
    Goods update(Goods goods);
    @Select("select * from tb_goods;")
    List<Goods> queryAll();
//   根据id查询
    @Select("select * from tb_goods where good_id = #{good_id};")
    Goods queryById(Integer id);

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

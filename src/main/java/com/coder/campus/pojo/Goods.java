package com.coder.campus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
* 商品表
 */
@TableName(value ="tb_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String goodId;
    private String name;
    private Float price;
    private Float originalPrice;
    private String description;
    private String img;
    private String createtime;
    private Integer num;
    private String tag;
}

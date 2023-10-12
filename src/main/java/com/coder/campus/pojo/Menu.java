package com.coder.campus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@TableName(value ="tb_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer id;
    private String name;
    private String url;
    private Integer fId;
    private List<Menu> child;
}

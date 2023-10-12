package com.coder.campus;

import com.coder.campus.mapper.GoodsMapper;
import com.coder.campus.mapper.LoginMapper;
import com.coder.campus.pojo.Menu;
import com.coder.campus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootDemo1ApplicationTests {
    @Autowired
    private LoginMapper loginMapper;
//    使用队列法查询菜单队列
    public  List<Menu> getMenuList(List<Menu> menus){
        LinkedList<Menu> queue = new LinkedList<>(menus);
        List<Menu> tree = new ArrayList<>();
        Map<Integer,Menu> menuMap = menus.stream().collect(Collectors.toMap(Menu::getId,node -> node));
        while (!queue.isEmpty()){
            Menu menu = queue.poll();
            if ( menu.getFId() == null || menu.getFId() == 0 ){
                tree.add(menu);
            }else {
                Menu fMenu = menuMap.get(menu.getFId());
                if (fMenu.getChild() == null){
                    List<Menu> child = new ArrayList<>();
                    fMenu.setChild(child);
                }
                fMenu.getChild().add(menu);
            }
        }
        return tree;
    }


    @Test
    void contextLoads(){
        User userInfo = loginMapper.queryUserInfo(2);
        List<Menu> menuList = getMenuList(userInfo.getMenus());
        userInfo.setMenuTree(menuList.get(0));
        System.out.println(userInfo.getRoles().size());
    }

}


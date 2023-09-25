package com.coder.campus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.campus.pojo.Admin;
import com.coder.campus.service.AdminService;
import com.coder.campus.utils.Result;
import com.coder.campus.utils.ResultCodeEnum;
import com.github.xiaoymin.knife4j.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: AdminController
 * Package: com.atguigu.campus.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/2/4 - 16:17  16:17
 * @Version: v1.0
 */
@Api(tags = "管理员控制层")
@RestController
@CrossOrigin
@RequestMapping("/sms/adminController")
public class AdminController {

    @Autowired
    private AdminService adminService;



    @ApiOperation("使用mybatisplus的分页插件查询数据")
    @GetMapping("/getAdmin/{pn}/{pageSize}")
    public Result<Object> getAllAdmin(@PathVariable("pn") Integer pn,
                                      @PathVariable("pageSize") Integer pageSize,
                                      String adminName){
        Page<Admin> page = adminService.page(new Page<>(pn, pageSize), new LambdaQueryWrapper<Admin>()
                .like(StrUtil.isNotBlank(adminName),
                        Admin::getName, adminName).orderByAsc(Admin::getId));
        return null;
    }
    @ApiOperation("添加")
    @PostMapping ("/add")
    public Result<Object> add(@RequestBody Admin admin){
        adminService.add(admin);
        return null;
    }

    @DeleteMapping("/delete")
    public Result<Object> delete(@RequestBody int id){
        adminService.delete(id);
        return null;
    }

    @GetMapping("/queryall")
    public List<Admin> queryall(){
        return null;
    }

    @GetMapping("/queryById/{id}")
    public Admin queryById(@PathVariable("id") int id){
        return adminService.queryById(id);
    }














}

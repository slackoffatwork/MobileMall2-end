package com.coder.campus.controller;
import com.coder.campus.mapper.AdminMapper;
import com.coder.campus.pojo.User;
import com.coder.campus.service.AdminService;
import com.coder.campus.service.LoginService;
import com.coder.campus.utils.CreateVerifiCodeImage;
import com.coder.campus.utils.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Api(tags = "登录接口")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private AdminService adminService;


    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ResultDTO login(String name, String password,HttpSession session) {
        ResultDTO login = loginService.login(name, password);
        session.setAttribute("login", login);
        return login;
    }
    @ApiOperation(value="生成验证码图片返回给浏览器")
    @GetMapping("/getVerifCodeImage")
    public void getVerifCodeImage(HttpServletRequest request, HttpServletResponse response){
//        生成验证码图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
//        获取验证码 返回值为char[] 数组 转换成字符串类型
        String verifiCode = new String(CreateVerifiCodeImage.getVerifiCode());
//        将验证码存入session中
        HttpSession session = request.getSession();
        session.setAttribute("verifiCode",verifiCode);
//        将验证码图片响应给浏览器 使用javax中的ImageIO
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    查询
    @ApiOperation(value = "JAVAEE练习 字段映射")
    @GetMapping("/queryUser")
    public ResultDTO<User> queryUser(String name, String password){
        User user = adminService.queryUser(name, password);
        return ResultDTO.okOf(user);
    }
}
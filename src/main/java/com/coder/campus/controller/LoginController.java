package com.coder.campus.controller;
import com.coder.campus.pojo.User;
import com.coder.campus.service.AdminService;
import com.coder.campus.service.GoodsService;
import com.coder.campus.service.LoginService;
import com.coder.campus.utils.CreateVerifiCodeImage;
import com.coder.campus.utils.JwtHelper;
import com.coder.campus.utils.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


@Api(tags = "登录接口")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private GoodsService goodsService;


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
//        将验证码存入session中 方便后续校验
        HttpSession session = request.getSession();
        session.setAttribute("verifiCode",verifiCode);
//        将验证码图片响应给浏览器 使用javax中的ImageIO
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @ApiOperation(value="登录校验")
    @PostMapping("/checkVerifCode")
    public ResultDTO<Object> checkVerifCode(@RequestBody User user, HttpSession session){
//        校验验证码
        String loginFormVerifiCode = user.getVerifiCode();
//        获取session中验证码的值
        Object code = session.getAttribute("verifiCode");
//        判断验证码值 是否超时 是否正确
        if (code != null){
            return ResultDTO.errorOf(500,"验证码超时");
        }
        if (!loginFormVerifiCode.equals(code)){
            return ResultDTO.errorOf(500,"验证码错误");
        }
        session.removeAttribute("verifiCode");
        Integer userType = user.getUserType();
        Map<String, Object> map = new LinkedHashMap<>();
        if (userType == 1){
            User user1 = loginService.doLogin(user);
            String token = JwtHelper.createToken(user1.getUserId().longValue(), userType);
            map.put("token",token);
        }
        return ResultDTO.okOf(map);
    }
    @ApiOperation(value = "映射到前端")
    @GetMapping("/doGetVerifCodeImage")
    public ResultDTO doGetVerifCodeImage() {
        return ResultDTO.okOf("http://localhost:8082/getVerifCodeImage");
    }

//    查询
    @ApiOperation(value = "JAVAEE练习 字段映射")
    @GetMapping("/queryUser")
    public ResultDTO<User> queryUser(String name, String password){
        User user = adminService.queryUser(name, password);
        return ResultDTO.okOf(user);
    }
@GetMapping("/doLogin")
    public User doLogin(User user){
        User doLogin = loginService.doLogin(user);
        return doLogin;
    }

}
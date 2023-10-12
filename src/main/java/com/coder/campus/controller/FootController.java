package com.coder.campus.controller;


import com.coder.campus.utils.ResultDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.Tool;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Api(tags = "管理员控制层")
@RestController
@CrossOrigin
@RequestMapping("/foot")
public class FootController {
    @GetMapping("/all")
    public ResultDTO foot(){
        return null;
    }
}

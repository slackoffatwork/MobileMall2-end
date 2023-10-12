package com.coder.campus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: LoginForm
 *
 * @author YZ
 * @Version: v1.0
 */

/**
 * 将登录的信息封装到该类 便于获取
 * @author YZ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;
}

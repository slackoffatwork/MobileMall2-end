package com.coder.campus.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Class {
    private Integer id;
    private String name;

    private List<User> user;
}

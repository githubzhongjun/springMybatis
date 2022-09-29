package com.example.springmybatis.entity.dto;

import com.example.springmybatis.entity.Classes;
import com.example.springmybatis.entity.User;

public class UserDto extends User {
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

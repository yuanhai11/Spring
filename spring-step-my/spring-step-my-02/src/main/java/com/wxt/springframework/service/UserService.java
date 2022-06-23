package com.wxt.springframework.service;

public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }
    public void queryUserInfo() {
        System.out.println("userService is be visited");
    }
}

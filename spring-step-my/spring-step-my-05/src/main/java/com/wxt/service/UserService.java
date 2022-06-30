package com.wxt.service;

import com.wxt.dao.UserDao;

public class UserService {
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }
}

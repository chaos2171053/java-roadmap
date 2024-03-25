package com.example.designpattern.proxy;

public class UserDaoProxy implements UserDao {
    private UserDao userDao;
    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    public void save() {
        System.out.println("开启事物...");
        userDao.save();
        System.out.println("关闭事物...");
    }
}

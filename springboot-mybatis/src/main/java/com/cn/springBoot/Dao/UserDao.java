package com.cn.springBoot.Dao;

import com.cn.springBoot.model.User;

import java.util.List;

/**
 * Created by cyq on 2017/11/22.
 */
public interface UserDao {
    public User find(String password);
    public List<User> findAll();
}

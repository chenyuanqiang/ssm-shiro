package com.cn.springBoot.service;

import com.cn.springBoot.model.User;

import java.util.List;

/**
 * Created by cyq on 2017/11/22.
 */
public interface UserService {
    public User find(String password);
    public List<User> findAll();
}

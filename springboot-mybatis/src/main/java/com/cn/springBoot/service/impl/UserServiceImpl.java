package com.cn.springBoot.service.impl;

import com.cn.springBoot.Dao.UserDao;
import com.cn.springBoot.model.User;
import com.cn.springBoot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 陈远强 on 2017/11/22.
 */
@Service
public class UserServiceImpl implements UserService {
   @Autowired
    UserDao dao;
    @Override
    public User find(String password) {
        System.out.println(password);
        return dao.find(password);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}

package com.shiro.service;

import com.shiro.model.User;


public interface UserService {
public User  loginCheck(User u);
public User loginByName(String loginName);
}

package com.shiro.dao;

import com.shiro.model.User;

public interface UserDao {

	public User loginCheck(User u);
	public User loginByName(String loginName);
}

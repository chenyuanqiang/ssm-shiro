package com.shiro.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiro.dao.UserDao;
import com.shiro.model.User;
import com.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;
	@Resource(name="sqlSession")
	public void setUserdao(SqlSession sqlsession) {
		this.userdao = sqlsession.getMapper(UserDao.class);
	}
	@Override
	public User loginCheck(User u) {
		return userdao.loginCheck(u);
	}
	@Override
	public User loginByName(String loginName) {
		return userdao.loginByName(loginName);
	}
	
}

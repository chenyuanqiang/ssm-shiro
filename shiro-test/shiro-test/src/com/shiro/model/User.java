package com.shiro.model;

import java.io.Serializable;

public class User implements Serializable {
 private String id ;
 private String loginName;
 private String password;
 private String username;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
 
}

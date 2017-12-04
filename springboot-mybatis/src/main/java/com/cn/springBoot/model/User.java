package com.cn.springBoot.model;

/**
 * Created by cyq on 2017/11/22.
 */
public class User {
    private  String id;
    private  String loginName;
    private String password;
    private String username;
    private int del_fag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDel_fag() {
        return del_fag;
    }

    public void setDel_fag(int del_fag) {
        this.del_fag = del_fag;
    }
}

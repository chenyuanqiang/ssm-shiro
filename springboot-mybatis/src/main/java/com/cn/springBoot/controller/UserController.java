package com.cn.springBoot.controller;

import com.cn.springBoot.model.User;
import com.cn.springBoot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by cyq on 2017/11/22.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("login")
    public String login(@RequestParam(required = false)String password, Model model){
    User   user= userService.find(password);
       model.addAttribute("user",user);
        return "login";
    }
    @RequestMapping("allUser")
    public String loginall(Model model){
        List<User> list=userService.findAll();
        model.addAttribute("user",list);
        return "login";
    }

}

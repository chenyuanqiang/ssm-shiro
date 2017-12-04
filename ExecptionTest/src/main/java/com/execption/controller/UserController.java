package com.execption.controller;

import com.execption.test.MyExecption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by cyq on 2017/12/4.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("/login")
    public String check(@RequestParam(required = false, value = "name") String name,
                        @RequestParam(required = false, value = "password") String pass)throws Exception {
        if ("".equals(name)) {
            throw  new MyExecption("error");
        }
        System.out.println("pass is="+pass);
        return "abc";
    }
}

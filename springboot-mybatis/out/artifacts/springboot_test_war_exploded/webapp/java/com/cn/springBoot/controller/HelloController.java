package com.cn.springBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cyq on 2017/11/21.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(){
        return  "hello-SpringBoot";
    }
}

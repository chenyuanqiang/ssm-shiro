package com.springBoot.Controller;

import org.springframework.stereotype.Controller;

/**
 * Created by cyq on 2017/12/4.
 */
@Controller
public class UserController {
   public  void login(String name,String password){
       System.out.println("name ="+name+":password="+password);
   }
}

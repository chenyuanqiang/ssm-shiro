package com.execption;

import com.execption.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by cyq on 2017/12/4.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args){
        ConfigurableApplicationContext context= SpringApplication.run(App.class,args);
        try {
            context.getBean(UserController.class)/*.check("","123")*/ ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

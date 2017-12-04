package com.execption.test;

import com.execption.model.result;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cyq on 2017/12/4.
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MyExecption.class)
    @ResponseBody
    public com.execption.model.result handler(HttpServletRequest re,MyExecption ex){
        result result=new result();
        result.setResultMess(ex.getMessage());
        result.setResultCode("500");
        result.setData(re.getRequestURI());
        return result;
    }
}

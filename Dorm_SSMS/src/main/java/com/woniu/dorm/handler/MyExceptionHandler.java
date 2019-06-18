package com.woniu.dorm.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class MyExceptionHandler {

	@ExceptionHandler
    public String execution(HttpServletRequest request, Exception ex){

        return "/html/500.jsp";
    }

}

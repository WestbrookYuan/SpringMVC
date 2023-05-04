package com.yty.springMVC.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class WebinfAction {
    @RequestMapping("/webinfo")
    public String WebinfoAction(){
        System.out.println("access to web info");
        return "index";
    }

    @RequestMapping("/webinfoMain")
    public String WebinfoMainAction(){
        System.out.println("access to web info main");
        return "main";
    }
    @RequestMapping("/showLogin")
    public String showLogin(){
        System.out.println("show login page");
        return "login";
    }

    @RequestMapping("/login")
    public String login(String user, String password, HttpServletRequest request){
        if ("admin".equals(user) && "admin".equals(password)){
            request.getSession().setAttribute("user", user);
            return "main";
        }
        else {
            request.setAttribute("msg", "verified failed");
            return "login";
        }

    }
}

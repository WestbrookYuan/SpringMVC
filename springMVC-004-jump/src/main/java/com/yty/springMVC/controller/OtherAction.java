package com.yty.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class OtherAction {
    @RequestMapping("/other.action")
    public String other(){
        System.out.println("other的访问");
        return "main";
    }
}

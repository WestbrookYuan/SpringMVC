package com.yty.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class ReqAction {
    @RequestMapping(value = {"/req.action"}, method = RequestMethod.GET)
    public String req(){
        System.out.println("by get request");
        return "main";
    }

    @RequestMapping(value = {"/req.action"}, method = RequestMethod.POST)
    public String req1(){
        System.out.println("by post request");
        return "main";
    }
}

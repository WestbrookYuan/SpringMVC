package com.yty.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class DemoAction {
    /*
    Action规范
    权限符 public
    任意返回值
    名称随意
    可以没有参数，也可以任意类型
    要是用@RequestMapping声明路径
     */

    @RequestMapping("/demo.action")
    public String demo(){
        System.out.println("get access to main");
        return "main";
    }
}

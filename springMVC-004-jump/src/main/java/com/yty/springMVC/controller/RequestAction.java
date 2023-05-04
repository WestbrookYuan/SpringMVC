package com.yty.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class RequestAction {
    /**
     * 默认使用视图解析器拼接前缀后缀进行页面跳转
     * @return
     */
    @RequestMapping("/one.action")
    public String One(){
        System.out.println("请求转发页面");
        return "main";
    }
    @RequestMapping("/two.action")
    public String Two(){
        // 只要是从客户端往controller里面跳，就要带上.action这个尾巴
        System.out.println("请求转发action");
        // forward可以屏蔽前后缀，实现请求转发跳转
        return "forward:/other.action";
    }

    @RequestMapping("/three.action")
    public String Three(){
        // 只要是从客户端往controller里面跳，就要带上.action这个尾巴
        System.out.println("重定向页面");
        // redirect可以屏蔽前后缀，实现请求重定向跳转
        return "redirect:/admin/main.jsp";
    }
    @RequestMapping("/four.action")
    public String Four(){
        // 只要是从客户端往controller里面跳，就要带上.action这个尾巴
        System.out.println("重定向action");
        // redirect可以屏蔽前后缀，实现请求重定向跳转
        return "redirect:/other.action";
    }
}

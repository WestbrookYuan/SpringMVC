package com.yty.springMVC.controller;

import com.yty.springMVC.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class ParamAction {
    @RequestMapping("/data.action")
    public String dataAction(HttpServletRequest request,
                             HttpServletResponse response,
                             HttpSession session,
                             Model model,
                             Map map,
                             ModelMap modelMap){
        User user = new User("syb", 25);
        request.setAttribute("requestUser", user);
        session.setAttribute("sessionUser", user);
        model.addAttribute("modelUser", user);
        map.put("mapUser", user);
        modelMap.addAttribute("modelMapUser", user);
//        return "main"; //请求转发页面
        return "redirect:/admin/main.jsp";
    }
}

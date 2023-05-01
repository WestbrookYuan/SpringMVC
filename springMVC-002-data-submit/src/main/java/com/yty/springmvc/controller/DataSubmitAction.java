package com.yty.springmvc.controller;

import com.yty.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class DataSubmitAction {
    @RequestMapping(value = {"/dataSubmitSingleData.action"})
    public String singleSubmit(String myname, int age){
        System.out.println(myname);
        System.out.println(age+100);
        return "main";
    }

    @RequestMapping(value = {"dataSubmitObjectData.action"})
    public String objectSubmit(User user){
        System.out.println(user);
        return "main";
    }

    /**
     *
     * @param name
     * @param age
     *     <a href="${pageContext.request.contextPath}/dataSubmitDynamicData/syb/25.action">dynamic submit</a>
     */
    @RequestMapping(value = {"dataSubmitDynamicData/{name}/{age}.action"})
    public String dynamicSubmit(@PathVariable("name") String name,@PathVariable("age") int age){
        System.out.println(name);
        System.out.println(age + 100);
        return "main";
    }

    @RequestMapping(value = "dataSubmitRequestParam.action")
    public String ParamMapping(@RequestParam("name") String uname, @RequestParam("age") Integer uage){
        System.out.println(uname);
        System.out.println(uage + 100);
        return "main";
    }
    @RequestMapping("dataSubmitSelf.action")
    public String Self(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(name);
        System.out.println(age + 100);
        return "main";
    }
}

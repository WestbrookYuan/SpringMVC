package com.yty.springMVC.controller;

import com.yty.springMVC.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class StuListAction {
    @RequestMapping("/list.action")
    @ResponseBody //解析ajax
    public List<Student> getStuList(){
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("wjs", 24));
        stuList.add(new Student("yty", 23));
        stuList.add(new Student("xcj", 25));
        return stuList; //Spring MVC convert it to json array
    }

    @RequestMapping("/oneStudent.action")
    @ResponseBody
    public Student student(){
        return new Student("申益彬", 26);
    }
}

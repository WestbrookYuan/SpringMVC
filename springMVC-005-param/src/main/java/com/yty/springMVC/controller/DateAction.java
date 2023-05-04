package com.yty.springMVC.controller;

import com.yty.springMVC.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Controller
public class DateAction {
//    @RequestMapping("/singleDate.action")
//    public String singleDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date myDate){
//
//        System.out.println(myDate);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String format = sdf.format(myDate);
//        System.out.println(format);
//        return "show";
//    }
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(
                        sdf,
                        true)
        );

    }
    @RequestMapping("/singleDate.action")
    public String singleDate(Date myDate, HttpServletRequest request){

        System.out.println(myDate);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String format = sdf.format(myDate);
//        System.out.println(format);
        request.setAttribute("myDate", sdf.format(myDate));
        return "show";
    }

    @RequestMapping("/showStudents.action")
    public String showStudents(HttpServletRequest request) throws ParseException {
        Student student = new Student("syb", sdf.parse("1998-04-01"));
        Student student2 = new Student("yty", sdf.parse("1999-11-14"));
        Student student3 = new Student("hhh", sdf.parse("1998-04-01"));
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        request.setAttribute("studentList", studentList);
        return "show";
    }
}

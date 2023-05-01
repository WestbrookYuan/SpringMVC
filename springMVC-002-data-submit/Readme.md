# SpringMVC 数据提交



### RequestMapping详解

1. 可以加在方法上，为方法注册一个可以访问的名称

   ```java
   @RequestMapping ("/demo")
   public String demo () {
   	system.out.println（"服务器被访问到了.......");
   	return "main"; //可以直接跳到/admin/main.jsp页面上
   }
   
   ＜a href="${pagecontext.reguest.contextPath}/demo.action">访问服务器</a>
   ```

2. 可以加到类上方，相当于是包名（虚拟路径），区分不同类中相同action的名称

   ```java
   @Controller
   @RequestMapping("/user")
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
   ＜a href="${pagecontext.reguest.contextPath}/demo.action">访问服务器</a>
   ```

3. 可区分get请求和post请求

   ```html
   <%--
     Created by IntelliJ IDEA.
     User: yuantengyan
     Date: 5/1/23
     Time: 3:23 PM
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>Title</title>
   </head>
   <body>
   <h2>Get</h2>
   <form method="get" action="${pageContext.request.contextPath}/req.action">
       <input type="submit" value="submit with get">
   </form>
   <br>
   <h2>Post</h2>
   <form method="post" action="${pageContext.request.contextPath}/req.action">
       <input type="submit" value="submit with post">
   </form>
   </body>
   </html>
   
   ```

   ```java
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
   
   ```

### SpringMVC优化的内容

![img](https://cdn.nlark.com/yuque/0/2022/png/22016332/1649670831990-7c457a67-3e0d-4300-9174-7c797e53d2bd.png)

#### 数据提交到action的方式

1. 散提交数据

   ```html
   <h2>single data submit</h2>
   <form action="${pageContext.request.contextPath}/dataSubmit.action">
       name:<input type="text" name="myname"><br>
       age:<input type="text" name="age"><br>
       <input type="submit" value="submit">
   </form>
   ```

   ```java
       @RequestMapping(value = {"/dataSubmit.action"})
       public String singleSubmit(String myname, int age){
           System.out.println(myname);
           System.out.println(age+100);
           return "main";
       }
   ```

2. 对象封装提交

   1. 在提交请求中，保证请求参数的名称与实体类中的成员变量保持一致，则可以自动提交数据，自动类型转换，自动封装数据到对象中

   ```java
       @RequestMapping(value = {"dataSubmitObjectData.action"})
       public String objectSubmit(User user){
           System.out.println(user);
           return "main";
       }
   ```

3. 动态占位符提交

   1. 仅限于超链接或地址栏提交数据，一杠一值，一杠一大括号，使用注解解析

   ```java
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
   ```

4. 映射名称不一致

   1. 提交请求参数与action形参不一致，使用注解@RequestParam来解析

   ```java
       @RequestMapping(value = "dataSubmitRequestParam.action")
       public String ParamMapping(@RequestParam("name") String uname, @RequestParam("age") Integer uage){
           System.out.println(uname);
           System.out.println(uage + 100);
           return "main";
       }
   ```

5. 手工提取数据

   1. 
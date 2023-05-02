# SpringMVC Ajax

### action方法的返回值

1. String：客户端资源的地址，自动拼接前缀和后缀。还可以屏蔽自动拼接字符串，可以指定返回的路径
2. Object：返回json格式的对象，自动将对象或集合转为json，使用的Jackson工具进行转换，必须添加依赖。一般用于Ajax请求
3. void：无返回值，一般用于Ajax请求
4. 基本数据类型：用于Ajax请求
5. model和view：返回数据和视图



### 实例：完成Ajax请求访问服务器，返回学生集合

1. 添加Jackson依赖

   ```xml
       <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
       <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.15.0</version>
       </dependency>
   ```

2. 新建js目录，添加JQuery函数库(jQuery 3.6.4)

3. 在index.jsp页面上导入函数库

   ```jsp
   <%--
     Created by IntelliJ IDEA.
     User: yuantengyan
     Date: 5/2/23
     Time: 1:21 PM
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>Title</title>
       <script src="js/jquery-3.6.4.js"></script>
   </head>
   <body>
       <a href="javascript:showStu()">get all students list</a> 
       <div id="mydiv">wait for data return</div>
       <script type="text/javascript">
         function showStu(){
           // use JQuery's ajax to send request
             $.ajax({
                 url:"${pageContext.request.contextPath}/list.action",
                 type:"get",
                 dataType:"json",
                 success:function (stuList){
                     var s = "";
                     $.each(stuList, function (i, stu){
                         s += stu.name + "---" + stu.age + "<br>";
                     });
                     $("#mydiv").html(s);
                 }
   
             });
         }
       </script>
   </body>
   </html>
   
   ```

4. 在action添加@ResponseBody，用来处理Ajax请求

   ```java
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
   }
   
   ```

5. 添加注解驱动\<mvc:annotationdriven/\>，用来解析ResponseBody注解

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          https://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/mvc
          https://www.springframework.org/schema/mvc/spring-mvc.xsd">
       <context:component-scan base-package="com.yty.springMVC.controller"/>
   <!--    处理Ajax请求，无需配置视图解析器-->
   <!--    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
   <!--        <property name="prefix" value="/admin/"/>-->
   <!--        <property name="suffix" value=".jsp"/>-->
   <!--    </bean>-->
       <mvc:annotation-driven/>
   </beans>
   ```

   
# SpringMVC 默认参数类型 日期类型处理

### SpringMVC 默认参数类型

1. SpringMVC默认的参数类型（无需创建，列出来就可用，可以进行数据携带）

   1. HttpServletRequest
   2. HttpServletResponse
   3. HttpSession
   4. Model
   5. Map
   6. ModelMap

   注意：Map,Model,ModelMap和reguest一样，都使用请求作用域进行数据传递。必须使用转发，如果使用重定向，只有session有

   ```java
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
   
   ```

   ```jsp
   <%--
     Created by IntelliJ IDEA.
     User: yuantengyan
     Date: 5/2/23
     Time: 11:37 PM
     To change this template use File | Settings | File Templates.
   --%>
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html>
   <head>
       <title>Title</title>
   </head>
   <body>
       <h2>main....</h2>
   <%--    request.setAttribute("requestUser", user);--%>
   <%--    session.setAttribute("sessionUser", user);--%>
   <%--    model.addAttribute("modelUser", user);--%>
   <%--    map.put("mapUser", user);--%>
   <%--    modelMap.addAttribute("modelMapUser", user);--%>
       <p>request User: ${requestUser}</p>
       <p>session User: ${sessionUser}</p>
       <p>model User: ${modelUser}</p>
       <p>map User: ${mapUser}</p>
       <p>modelMap User: ${modelMapUser}</p>
   <%--    from index.jsp--%>
       <p>from index.jsp ${param.name}</p>
   </body>
   </html>
   
   ```



### 日期类型处理

1. 日期的提交

   1. 单个日期处理

      1. 使用@DateTimeFormat
      2. 必须搭配mvc:annotation-driven

   2. 多个日期处理

      1. 注册一个注解,用来解析本类中所有的日期类型，自动转换

      2. 完成对应的函数

         ```java
             @InitBinder
             public void initBinder(WebDataBinder dataBinder){
                 dataBinder.registerCustomEditor(Date.class,
                         new CustomDateEditor(
                                 new SimpleDateFormat("yyyy-MM-dd"),
                                 true)
                 );
         
             }
             @RequestMapping("/singleDate.action")
             public String singleDate(Date myDate){
         
                 System.out.println(myDate);
         //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         //        String format = sdf.format(myDate);
         //        System.out.println(format);
                 return "show";
             }
         ```

         

2. 日期的显示

   1. 单个日期显示

      1. 提前进行日期转换成字符串，再传入request（**改变了日期类型**）

   2. 如果是list或实体类中的成员变量

      1. 必须使用JSTL标签库

         ```xml
             <dependency>
               <groupId>org.glassfish.web</groupId>
               <artifactId>jakarta.servlet.jsp.jstl</artifactId>
               <version>2.0.0</version>
             </dependency>
         
             <dependency>
               <groupId>org.apache.taglibs</groupId>
               <artifactId>taglibs-standard-spec</artifactId>
               <version>1.2.5</version>
             </dependency>
         
             <dependency>
               <groupId>org.apache.taglibs</groupId>
               <artifactId>taglibs-standard-impl</artifactId>
               <version>1.2.5</version>
             </dependency>
         ```

      2. 导入jstl标签库和fmt标签库

         ```jsp
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <%--
           Created by IntelliJ IDEA.
           User: yuantengyan
           Date: 5/3/23
           Time: 12:20 AM
           To change this template use File | Settings | File Templates.
         --%>
         <%@ page contentType="text/html;charset=UTF-8" language="java" %>
         <html>
         <head>
             <title>Title</title>
         </head>
         <body>
             <h2>show time</h2>
             <p>${myDate}</p>
             <h2>student List</h2>
             <table width="800px" border="1">
                 <tr>
                     <th>name</th>
                     <th>birthday</th>
                 </tr>
                 <c:forEach items="${studentList}" var="stu">
                     <tr>
                         <td>${stu.name}</td>
                         <td>${stu.birthday} ---- <fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate>  </td>
                     </tr>
                 </c:forEach>
         
             </table>
         </body>
         </html>
         
         ```

   3. 补充：

      1. 方法上使用@DateTimeFormat
      2. set方法使用@DateTimeFormat
      3. 对于Json，get方法使用@DateTimeFormat

   \<mvcannotation-driven/\>标签的使用

   \<mvc:annotation-driven/\>会自动注册两个bean，分别为

   DefaultAnnotationHandlerMapping和 AnnotationMethodHandlerAdapter。是 springmvc. 为

   @controller 分发请求所必领的。除了注册了这两个bean，还提供了很多支持。

   1）支持使用 ConversionService 实例对表单参数进行类型转换；

   2）支持使用 @NumberFormat、@DateTimeFormat;

   了）注解完成数据类型的格式化；

   4）支持使用 @RequestBody 和 @ResponseBody 注解；

   5）静态资源的分流也使用这个标签；

   

   


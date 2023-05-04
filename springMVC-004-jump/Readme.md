# SpringMVC 跳转 默认参数类型

1. 跳转的四种模式
   1. 转发页面
   2. 转发action
   3. 重定向页面
   4. 重定向action

   ```java
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
   
   
   
   ```

2. SpringMVC默认的参数类型（无需创建，列出来就可用，可以进行数据携带）

   1. HttpServletRequest
   2. HttpServletResponse
   3. HttpSession
   4. Model
   5. Map
   6. ModelMap

   注意：Map,Model,ModelMap和reguest一样，都使用请求作用域进行数据传递。必须使用转发

3. 


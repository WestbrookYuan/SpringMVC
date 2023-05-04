# SpringMVC 访问WEB-INF 拦截器

1. 在WEB-INF目录下的文件，不能直接访问，只能通过请求转化的方式进行访问

   ```java
   package com.yty.springMVC.controller;
   
   import jakarta.servlet.http.HttpServletRequest;
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.RequestMapping;
   
   /**
    * @author yty
    * @version 1.0
    * @since 1.0
    **/
   @Controller
   public class WebinfAction {
       @RequestMapping("/webinfo")
       public String WebinfoAction(){
           System.out.println("access to web info");
           return "index";
       }
   
       @RequestMapping("/webinfoMain")
       public String WebinfoMainAction(){
           System.out.println("access to web info main");
           return "main";
       }
       @RequestMapping("/showLogin")
       public String showLogin(){
           System.out.println("show login page");
           return "login";
       }
   
       @RequestMapping("/login")
       public String login(String user, String password, HttpServletRequest request){
           if ("admin".equals(user) && "admin".equals(password)){
               return "main";
           }
           else {
               request.setAttribute("msg", "verified failed");
               return "login";
           }
   
       }
   }
   
   
   ```



### SpringMVC 拦截器

![截屏2023-05-03 下午8.54.38](/Users/yuantengyan/IdeaProjects/SpringMVC/springMVC-006-webinfo/截屏2023-05-03 下午8.54.38.png)

1. 拦截器执行的时机

   1. preHandle():在清求被处理之前逃行操作
   2. postHandle():正在请求被处理之后，但结果还没有渲染前进行操作，可以改变响应结果
   3. afterCompletion():所有的请求响应结束后执行善后工作,清理对象,关闭资源

2. 拦截器的两种实现方式

   1. 继承HandlerInterceptorAdapter的父类
   2. 实现HandlerInterceptor接口，实现的接口,推荐使用实现接口的方式

3. 拦截器的实现步骤

   1. 改造登录方法，在session中存储用广信息,用于进行权限验证

      ```java
      @RequestMapping("/login")
          public String login(String user, String password, HttpServletRequest request){
              if ("admin".equals(user) && "admin".equals(password)){
                  request.getSession().setAttribute("user", user);
                  return "main";
              }
              else {
                  request.setAttribute("msg", "verified failed");
                  return "login";
              }
      
          }
      ```

   2. 开发拦截器的功能．实现HandlerInterceptor接口,重写preHandle()方法

      ```java
      package com.yty.springMVC.interpreter;
      
      import jakarta.servlet.http.HttpServletRequest;
      import jakarta.servlet.http.HttpServletResponse;
      import org.springframework.web.servlet.HandlerInterceptor;
      
      /**
       * @author yty
       * @version 1.0
       * @since 1.0
       **/
      public class LoginInterpreter implements HandlerInterceptor {
          @Override
          public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
              Object user = request.getSession().getAttribute("user");
              if (user != null){
                  return true;
              }
              else {
                  request.setAttribute("msg", "not login");
                  request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
                  return false;
              }
          }
      }
      
      ```

   3. 在springmvc.xm1文件中注册拦截器，mapping是不放行，exclude-mapping是放行的

      ```xml
      <mvc:interceptors>
              <mvc:interceptor>
                  <mvc:mapping path="/**"/>
                  <mvc:exclude-mapping path="/showLogin"/>
                  <mvc:exclude-mapping path="/login"/>
                  <bean class="com.yty.springMVC.interpreter.LoginInterpreter"/>
              </mvc:interceptor>
          </mvc:interceptors>
      ```

   4. 
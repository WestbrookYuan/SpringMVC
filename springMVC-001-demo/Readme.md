# SpringMVC

### 什么是SpringMVC

它是基于MVC开发模式的框架,用来优化控制器.它是Spring家族的一员.它也具备IOC和AOP.



1. 什么是MVC

   1. 它是一种开发模式,它是模型视图控制器的简称.所有的web应用都是基于MVC开发.
   2. M:模型层,包含实体类,业务逻辑层,数据访问层
   3. V:视图层,html,javaScript,vue等都是视图层,用来显现数据
   4. C:控制器,它是用来接收客户端的请求,并返回响应到客户端的组件,Servlet就是组件

2. SpringMVC框架的优点

   1. 轻量级
   2. 易于上手
   3. 具备IOC和AOP
   4. 完全基于注解开发

   ![image.png](https://cdn.nlark.com/yuque/0/2022/png/22016332/1649646530102-ac7e10d0-7f53-43a2-9d15-30e0d19354d1.png?x-oss-process=image%2Fresize%2Cw_1143%2Climit_0)

   ### 简单实现一个SpringMVC的webapp

   1. 选择maven archetype的webapp，添加java文件夹、resource文件夹到main和test中

   2. 修改pom文件

      ```xml
      <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>com.yty</groupId>
        <artifactId>springMVC-001-demo</artifactId>
        <packaging>war</packaging>
        <version>1.0-SNAPSHOT</version>
        <properties>
          <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
          <maven.compiler.source>17</maven.compiler.source>
          <maven.compiler.target>17</maven.compiler.target>
        </properties>
        <repositories>
          <repository>
            <id>repository.spring.milestone</id>
            <name>Spring Milestone Repository</name>
            <url>https://repo.spring.io/milestone</url>
          </repository>
        </repositories>
        <dependencies>
          <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
          </dependency>
          <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>6.0.0-M2</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api -->
          <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.0.0</version>
          </dependency>
        </dependencies>
        <build>
          <resources>
            <resource>
              <directory>src/main/java</directory>
              <includes>
                <include>**/*.xml</include>
                <include>**/*.properties</include>
              </includes>
            </resource>
            <resource>
              <directory>src/main/resources</directory>
              <includes>
                <include>**/*.xml</include>
                <include>**/*.properties</include>
              </includes>
            </resource>
          </resources>
        </build>
      </project>
      
      ```

   3. 添加SpringMVC配置文件(包扫描和ResourceViewResolver)

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns:context="http://www.springframework.org/schema/context"
             xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
          <context:component-scan base-package="com.yty.springMVC.controller"/>
          <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
              <property name="prefix" value="/admin/"/>
              <property name="suffix" value=".jsp"/>
          </bean>
      
      </beans>
      ```

   4. 新建web.xml（注册springMVC框架、注册DispatchServlet，纳入Tomcat管理）

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
               version="4.0">
          <servlet>
              <servlet-name>springMVC</servlet-name>
              <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
              <init-param>
                  <param-name>contextConfigLocation</param-name>
                  <param-value>classpath:springmvc.xml</param-value>
              </init-param>
          </servlet>
          <servlet-mapping>
              <servlet-name>springMVC</servlet-name>
              <url-pattern>*.action</url-pattern>
          </servlet-mapping>
      </web-app>
      
      ```






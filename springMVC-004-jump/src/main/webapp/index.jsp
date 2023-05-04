<%--
  Created by IntelliJ IDEA.
  User: yuantengyan
  Date: 5/2/23
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/one.action">1. 请求转发页面(默认)</a><br>
    <a href="${pageContext.request.contextPath}/two.action">2. 请求转发action</a><br>
    <a href="${pageContext.request.contextPath}/three.action">3. 重定向页面</a><br>
    <a href="${pageContext.request.contextPath}/four.action">4. 重定向action</a><br>
</body>
</html>

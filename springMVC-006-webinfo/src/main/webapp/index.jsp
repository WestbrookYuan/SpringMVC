<%--
  Created by IntelliJ IDEA.
  User: yuantengyan
  Date: 5/3/23
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/webinfo">get to web inf index jsp</a>
    <br>
    <a href="${pageContext.request.contextPath}/webinfoMain">get to web inf main jsp</a>
    <br>
    <a href="${pageContext.request.contextPath}/showLogin">get to web login jsp</a>
</body>
</html>

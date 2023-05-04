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
    <a href="${pageContext.request.contextPath}/data.action?name=yty">数据携带跳转</a>
    <br><br><br>
    <form method="post" action="${pageContext.request.contextPath}/singleDate.action">
        <input type="date" name="myDate">
        <input type="submit" value="submit">
    </form>
    <br>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/showStudents.action">
        显示学生信息
    </a>
</body>
</html>

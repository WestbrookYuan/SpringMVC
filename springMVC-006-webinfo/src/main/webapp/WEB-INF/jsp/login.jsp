<%--
  Created by IntelliJ IDEA.
  User: yuantengyan
  Date: 5/3/23
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="user"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="submit">
    </form><br><br><br>
    ${msg}
</body>
</html>

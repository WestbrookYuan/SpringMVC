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

<h2>Post</h2>
    <form method="post" action="${pageContext.request.contextPath}/req.action">
        <input type="submit" value="submit with post">
    </form>

<h2>single data submit</h2>
    <form action="${pageContext.request.contextPath}/dataSubmitSingleData.action">
        name:<input type="text" name="myname"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="submit">
    </form>

<h2>object data submit</h2>
    <form action="${pageContext.request.contextPath}/dataSubmitObjectData.action">
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="submit">
    </form>

<h2>dynamic data submit</h2>
    <a href="${pageContext.request.contextPath}/dataSubmitDynamicData/syb/25.action">dynamic submit</a>

<h2>request parameter different</h2>
    <form action="${pageContext.request.contextPath}/dataSubmitRequestParam.action">
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="submit">
    </form>

<h2>get data by self</h2>
    <form action="${pageContext.request.contextPath}/dataSubmitSelf.action">
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>

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

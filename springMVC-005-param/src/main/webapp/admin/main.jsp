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

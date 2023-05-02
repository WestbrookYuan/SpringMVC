<%--
  Created by IntelliJ IDEA.
  User: yuantengyan
  Date: 5/2/23
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.4.js"></script>
</head>
<body>
    <a href="javascript:showStu()">get all students list</a> 
    <div id="mydiv">wait for data return</div>
    <script type="text/javascript">
      function showStu(){
        // use JQuery's ajax to send request
          $.ajax({
              url:"${pageContext.request.contextPath}/list.action",
              type:"get",
              dataType:"json",
              success:function (stuList){
                  var s = "";
                  $.each(stuList, function (i, stu){
                      s += stu.name + "---" + stu.age + "<br>";
                  });
                  $("#mydiv").html(s);
              }

          });
      }
    </script>

    <a href="javascript:getOneStu()">get a student</a>
    <div id="myStu">wait for one student</div>
    <script type="text/javascript">
        function getOneStu() {
            $.ajax({
                url: "${pageContext.request.contextPath}/oneStudent.action",
                type: "get",
                dataType: "json",
                success: function (student){
                    var s = "";
                    s += student.name + "----" + student.age;
                    $("#myStu").html(s);
                }
            });
        }
    </script>
</body>
</html>

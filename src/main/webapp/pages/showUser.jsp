<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2018/1/14
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show User</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        function loadData() {
            $("#userTab tr:not(:first)").remove();
            $.post("${pageContext.request.contextPath}/userAction/findUsersList", null, function (data) {
                console.log(data);
                if (data && data.length > 0) {
                    $.each(data, function (i, v) {
                        var tr = "<tr><td>" + (i + 1) + "</td><td>" + v.uname + "</td></tr>";
                        $("#userTab").append(tr);
                    });
                }
            }, "json");
        }
        window.onload = loadData;
    </script>
</head>
<body>
<h2>用户列表</h2>
<table border="1" width="200" id="userTab">
    <tr>
        <th>编号</th>
        <th>用户名</th>
    </tr>
</table>
</body>
</html>


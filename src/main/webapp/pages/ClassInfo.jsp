<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/24
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Class List</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        function loadData() {
            $("#clsTab tr:not(:first)").remove();
            $.post("${pageContext.request.contextPath}/clsAction/findClsList", null, function (data) {
                console.log(data);
                if (data && data.length > 0) {
                    $.each(data, function (i, v) {
                        var tr = "<tr><td>" + (i + 1) + "</td><td>" + v[1] + "</td><td>" + v[2] + "</td><td><a href='${pageContext.request.contextPath}/clsAction/getClsById/sdk/" + v [0] + "/ktl'>修改</a> | <a href='javascript:;' onclick = 'deleteCls(" + v[0] + ")'>删除</a></td></tr>";
                        $("#clsTab").append(tr);
                    });
                }
            }, "json");
        }
        window.onload = loadData;

        function deleteCls(cno) {
            $.post("${pageContext.request.contextPath}/clsAction/deleteCls", "cno=" + cno, function (data) {
                if (data && data == true) {
                    loadData();
                    $("#msg").html("删除成功！").css("color","green");
                }else{
                    $("#msg").html("删除失败！").css("color","red");
                }
            }, "json");
        }
    </script>
</head>
<body>
<h2>班级列表</h2>
<div id="msg"></div>
<table id="clsTab" border="1" width="500">
    <tr>
        <th>编号</th>
        <th>班级名称</th>
        <th>班级人数</th>
        <th>管理</th>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/pages/AddCls.jsp">添加班级</a>
</body>
</html>

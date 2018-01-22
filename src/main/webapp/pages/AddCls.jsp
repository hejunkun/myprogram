<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/24
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCls</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        function addCls(){
            var param = $("#addForm").serialize();
            $.post("${pageContext.request.contextPath}/clsAction/AddCls", param, function (data) {
                if(data && data == true){
                    $("#addForm")[0].reset();
                    $("#msg").html("添加班级成功!").css("color","green");
                }else{
                    $("#msg").html("添加班级失败!").css("color","red");
                }
            }, "json");
        }
    </script>
</head>
<body>
<h2>添加班级</h2>
<div id="msg"></div>
<form id="addForm" onsubmit="return false">
    班级名称：<input name="cname" />
    <input type="button" onclick="addCls()" onblur="$('#msg').html('')" value="添加班级">
</form>
<a href="${pageContext.request.contextPath}/pages/ClassInfo.jsp">班级列表</a>
</body>
</html>

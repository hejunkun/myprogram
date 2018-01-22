<%--
  Created by IntelliJ IDEA.
  User: LARK
  Date: 2017/11/19
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Cls</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        function updateCls(){
            var param = $("#updateForm").serialize();
            $.post("${pageContext.request.contextPath}/clsAction/updateCls", param, function (data) {
                if(data && data == true)
                    location.href = "${pageContext.request.contextPath}/pages/ClassInfo.jsp";
                else
                    $("#msg").html("修改失败").css("color","red");
            }, "json");
        }
    </script>
</head>
<body>
<h2>修改班级</h2>
<div id="msg"></div>
<form id="updateForm" id="updateCls" onsubmit="return false">
    <input type="hidden" name="cno" value="${cls.cno}" />
    班级名称：<input name="cname" value="${cls.cname}" />
    <input type="button" onclick="updateCls()" onblur="$('#msg').html('')" value="修改班级">
</form>
<a href="${pageContext.request.contextPath}/pages/ClassInfo.jsp">班级列表</a>
</body>
</html>

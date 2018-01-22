<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2018/1/15
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Stu</title>
</head>
<body>
<h2>修改用户</h2>
    <div id="msg"></div>
    <form id="myform" method="post">
        <input type="hidden" name="uno" value="${sessionScope.loginUser.uno}">
        旧  密  码：<input name="upwd" /><br />
        新  密  码：<input name="newpwd" /><br />
        确 认 密 码：<input name="repwd" /><br />
        <input type="button" onclick="onSubmit()" value="修改用户">
    </form>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script>
    function onSubmit() {
        var repwd = document.getElementsByName("repwd")[0].value;
        var newpwd = document.getElementsByName("newpwd")[0].value;
        if(repwd != newpwd){
            alert('密码不一致！');
            return false;
        }
        var param = $("#myform").serialize();
        $.post("${pageContext.request.contextPath}/userAction/updateUser", param, function (res) {
            if(res == "success"){
                alert("修改密码成功！");
            }
        });
    }
</script>
</html>

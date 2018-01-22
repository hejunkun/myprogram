<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/24
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>AddStu</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>添加学生</h2>
<div id="msg"></div>
<fmt:formatDate var="intime"  value="${backStu.stime}" pattern="yyyy-MM-dd"/>
<form id="myform" action="${pageContext.request.contextPath}/stuAction/addStu" method="post">
    学生姓名：<input name="sname" value="${backStu.sname}" /><br/>
    学生年龄：<input name="sage" value="${backStu.sage}" /><br />
    学生性别：<input type="radio" name="ssex" value="1" checked />男
              <input type="radio" name="ssex" value="0" />女<br />
    入学时间：<input type="date" name="stime" /><br />
    电话号码：<input name="sphone" value="${backStu.sphone}" /><br />
    选择班级：<select name="cls.cno">
    <option value="">请选择班级</option>
    <c:forEach items="${requestScope.clsList}" var="o" varStatus="ids">
        <option value="${o.cno}">${o.cname}</option>
    </c:forEach>
</select>
    <br />
    <input type="submit" value="添加学生">
</form>
<script>

    if("${addMessage}" == "1")
        $("#msg").html("添加成功！").css("color","green");
    else if("${addMessage}" == "-1")
        $("#msg").html("添加失败！").css("color","red");

</script>
<script>
    var sex = document.getElementsByName("ssex");
    var select = document.getElementsByName("cls.cno");
    //绑定性别
    console.log("${backStu.ssex}")

    "${backStu.ssex}" === 0 || "${backStu.ssex}" === "0" ? sex[1].checked = true : sex[0].checked = true;

    //绑定班级
    for(var i = 0; i < select[0].options.length; i ++){
        var p = select[0].options[i];
        if(p.value == "${backStu.cls.cno}"){
            p.selected = true;
            break;
        }
    }
</script>
<a href="${pageContext.request.contextPath}/stuAction/findStuList">学生列表</a>
</body>
</html>

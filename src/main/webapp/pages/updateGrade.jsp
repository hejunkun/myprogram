<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2018/1/8
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UpdateGrade</title>
</head>
<body>
<h2>修改学生</h2>
<div id="msg"></div>
<form action="${pageContext.request.contextPath}/gradeAction/updateGrade" method="post">
    <input type="hidden" name="gno" value="${grade.gno}">
    选择班级：
    <select name="cls.cno">
        <option value="">请选择班级</option>
        <c:forEach items="${clsList}" var="o" varStatus="ids">
            <option value="${o.cno}">${o.cname}</option>
        </c:forEach>
    </select>
    <br />

    学生姓名：<input name="gname" value="${grade.gname}" /><br />
    语文成绩：<input name="gchinese" value="${grade.gchinese}" /><br />
    数学成绩：<input name="gmath" value="${grade.gmath}" /><br />
    英语成绩：<input name="genglish" value="${grade.genglish}" /><br />
    <input type="submit" value="修改学生">
</form>
<a href="${pageContext.request.contextPath}/gradeAction/findGradeList">学生列表</a>
<script>
    var select = document.getElementsByName("cls.cno");
    //绑定班级
    for(var i = 0; i < select[0].options.length; i ++){
        var p = select[0].options[i];
        if(p.value == "${grade.cls.cno}"){
            p.selected = true;
            break;
        }
    }
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2018/1/8
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>AddGrade</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>添加成绩</h2>
<div id="msg"></div>
<form id="myform" action="${pageContext.request.contextPath}/gradeAction/addGrade" method="post">
    选择班级：
    <select name="cls.cno">
        <option value="">请选择班级</option>
        <c:forEach items="${requestScope.clsList}" var="o" varStatus="ids">
            <option value="${o.cno}">${o.cname}</option>
        </c:forEach>
    </select>
    <br />
    学生姓名：<input name="gname" value="${backGrade.gname}" /><br/>
    语文成绩：<input name="gchinese" value="${backGrade.gchinese}" /><br />
    数学成绩：<input name="gmath" value="${backGrade.gmath}" /><br />
    英语成绩：<input name="genglish" value="${backGrade.genglish}" /><br />
    <input type="submit" value="添加成绩">
</form>
<script>
    if("${addMessage}" == "1")
        $("#msg").html("添加成功！").css("color","green");
    else if("${addMessage}" == "-1")
        $("#msg").html("添加失败！").css("color","red");
</script>
<script>
    var select = document.getElementsByName("cls.cno");
    //绑定班级
    for(var i = 0; i < select[0].options.length; i ++){
        var p = select[0].options[i];
        if(p.value == "${backGrade.cls.cno}"){
            p.selected = true;
            break;
        }
    }
</script>
<a href="${pageContext.request.contextPath}/gradeAction/findGradeList">学生列表</a>
</body>
</html>


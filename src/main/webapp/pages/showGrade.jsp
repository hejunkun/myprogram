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
    <title>ShowGrade</title>
</head>
<body>
<h2>学生成绩列表</h2>
<c:if test="${updateMsg == '1'}">
    <p style="color:green">修改成功</p>
</c:if>
<c:if test="${deleteMsg == '1'}">
    <p style="color:green">删除成功</p>
</c:if>
<c:if test="${deleteMsg == '-1'}">
    <p style="color:green">删除失败</p>
</c:if>
<table border="1" width="800">
    <tr>
        <th>编号</th>
        <th>学生名字</th>
        <th>班级名称</th>
        <th>语文成绩</th>
        <th>数学成绩</th>
        <th>英语成绩</th>
        <th>总分</th>
        <th>管理</th>
    </tr>
    <c:forEach items="${gradeList}" var="o" varStatus="ids">
        <tr>
            <td>${ids.count}</td>
            <td>${o[0].gname}</td>
            <td>${o[1].cname}</td>
            <td>${o[0].gchinese}</td>
            <td>${o[0].gmath}</td>
            <td>${o[0].genglish}</td>
            <td>${o[0].gchinese+o[0].genglish+o[0].genglish}</td>
            <td>
                <a href="${pageContext.request.contextPath}/gradeAction/getGradeById/stk/${o[0].gno}/ktl">修改</a>
                <a href="${pageContext.request.contextPath}/gradeAction/deleteGrade/stk/${o[0].gno}/ktl">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/gradeAction/findClsList">添加成绩</a>
</body>
</html>

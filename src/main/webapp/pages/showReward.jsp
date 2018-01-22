<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2018/1/8
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>荣誉列表</h2>
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
        <th>班级名称</th>
        <th>学生姓名</th>
        <th>具体奖励信息</th>
        <th>管理</th>
    </tr>
    <c:forEach items="${rewardList}" var="o" varStatus="ids">
        <tr>
            <td>${ids.count}</td>
            <td>${o[2].cname}</td>
            <td>${o[1].sname}</td>
            <td>${o[0].rinfo}</td>
            <td>
                <a href="${pageContext.request.contextPath}/rewardAction/deleteReward/stk/${o[0].rno}/ktl">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/rewardAction/findClsList">添加荣誉</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: LARK
  Date: 2017/11/20
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Stu</title>
</head>
<body>
    <h2>学生列表</h2>
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
            <th>学生年龄</th>
            <th>学生性别</th>
            <th>入学时间</th>
            <th>电话号码</th>
            <th>管理</th>
        </tr>
        <c:forEach items="${stuList}" var="o" varStatus="ids">
            <tr>
                <td>${ids.count}</td>
                <td>${o[1].cname}</td>
                <td>${o[0].sname}</td>
                <td>${o[0].sage}</td>
                <td>${o[0].ssex == 1?"男":"女"}</td>
                <td>${o[0].stime.toString().substring(0,10)}</td>
                <td>${o[0].sphone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/stuAction/getStuById/stk/${o[0].sno}/ktl">修改</a>
                    <a href="${pageContext.request.contextPath}/stuAction/deleteStu/stk/${o[0].sno}/ktl">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/stuAction/findClsList">添加学生</a>
</body>
</html>

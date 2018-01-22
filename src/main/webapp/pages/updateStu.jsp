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
    <title>Update Stu</title>
</head>
<body>
    <h2>修改学生</h2>
    <div id="msg"></div>
    <form action="${pageContext.request.contextPath}/stuAction/updateStu" method="post">
        <input type="hidden" name="sno" value="${stu.sno}">
        学生姓名：<input name="sname" value="${stu.sname}" /><br />
        学生年龄：<input name="sage" value="${stu.sage}" /><br />
        学生性别：<input type="radio" name="ssex" value="1" />男
        <input type="radio" name="ssex" value="0" />女<br />
        入学时间：<input name="stime" value="${stu.stime.toString().substring(0,10)}" /><br />
        电话号码：<input name="sphone" value="${stu.sphone}" /><br />
        选择班级：<select name="cls.cno">
        <option value="">请选择班级</option>
        <c:forEach items="${clsList}" var="o" varStatus="ids">
            <option value="${o.cno}">${o.cname}</option>
        </c:forEach>
    </select>
        <br />
        <input type="submit" value="修改学生">
    </form>
    <a href="${pageContext.request.contextPath}/stuAction/findStuList">学生列表</a>
    <script>
        var sex = document.getElementsByName("ssex");
        var select = document.getElementsByName("cls.cno");
        //绑定性别
        console.log("${stu.ssex}")
        "${stu.ssex}" == 1 ? sex[0].checked = true : sex[1].checked = true;

        //绑定班级
        for(var i = 0; i < select[0].options.length; i ++){
            var p = select[0].options[i];
            if(p.value == "${stu.cls.cno}"){
                p.selected = true;
                break;
            }
        }
    </script>
</body>
</html>

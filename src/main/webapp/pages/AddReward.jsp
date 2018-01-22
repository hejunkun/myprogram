<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2018/1/8
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>AddReward</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>添加荣誉</h2>
<div id="msg"></div>
<form id="myform" action="${pageContext.request.contextPath}/rewardAction/addReward" method="post">
    选择班级：
    <select name="cls.cno" id="sele">
    <option value="" >请选择班级</option>
    <c:forEach items="${requestScope.clsList}" var="o" varStatus="ids">
        <option value="${o.cno}">${o.cname}</option>
    </c:forEach>
    </select>
    <br />
    选择学生：
    <select name="stu.sno" id="seleStu">
        <option value="">请选择学生</option>
    </select>
    <br />
    具体奖励信息：<input name="rinfo" value="${backReward.rinfo}" /><br/>
    <input type="submit" value="添加荣誉">
</form>
<script>
    if("${addMessage}" == "1")
        $("#msg").html("添加成功！").css("color","green");
    else if("${addMessage}" == "-1")
        $("#msg").html("添加失败！").css("color","red");
</script>
<script>
    //异步：根据班级ID查询出学生
    $("#sele").change(function(){
       var clsId = $("#sele").val();
       $.post("${pageContext.request.contextPath}/rewardAction/findStuByClsId?cno="+clsId,"",function(data){
           $.each(data,function(i,v){
            var opt = "<option value='"+v.sno+"'>"+v.sname+"</option>"
                $("#seleStu").append(opt);
           })
       })
    });
</script>
<a href="${pageContext.request.contextPath}/rewardAction/findRewardList">奖励列表</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/11/8
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生管理系统主页</title>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
        }
        #myiframe{
            width: 1150px;
            height: 555px;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:;toSchoolInfo();">关于学校</a></li>
            <li class="layui-nav-item"><a href="javascript:;toshowUser();">用户列表</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/images/nf.jpg" class="layui-nav-img">
                    ${param.uname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;toUpdateUpwd();">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    其他
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/userAction/exitLogin">退出</a>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;toAddStu();">学生录入</a></dd>
                        <dd><a href="javascript:;toshowStu();">学生管理</a></dd>
                        <dd><a href="javascript:;toAddCls();">添加班级</a></dd>
                        <dd><a href="javascript:;toClassInfo();">班级管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">教务中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;toGrade();">成绩管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">荣誉</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;toReward();">个人荣誉</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="myiframe" src="Context.jsp"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        南方教育，成就你我！
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });

    //跳转到用户修改密码页面
    function toUpdateUpwd(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/updateUser.jsp");
    }

    //跳转到学生录入页面
    function toAddStu(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/stuAction/findClsList");
    }
    //跳转到学生信息页面
    function toshowStu(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/stuAction/findStuList");
    }
    //跳转到班级录入页面
    function toAddCls(){
        $("#myiframe").attr("src","../pages/AddCls.jsp");
    }
    //跳转到班级信息页面
    function toClassInfo(){
        $("#myiframe").attr("src","../pages/ClassInfo.jsp");
    }

    //跳转到成绩管理页面
    function toGrade(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/gradeAction/findClsList");
    }

    //跳转到个人荣誉页面
    function toReward(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/rewardAction/findClsList");
    }

    //跳转到个人荣誉页面
    function toSchoolInfo(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/SchoolInfo.jsp");
    }
    //跳转到用户管理页面
    function toshowUser(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/showUser.jsp");
    }

</script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 长夜
  Date: 2023/3/23
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" type="text/css">
    <style>
        .link{
            color: red;!important;
        }
    </style>
</head>
<body>
    <div class="container">
        <div id="top">
            <div class="headerLine">————————————————</div>
            <div id="header">课程管理</div>
            <div class="headerLine">————————————————</div>
        </div>
        <div>
            <a href="/course/add_page" class="btn1">新增</a>
            <a href="#" class="btn2">批量删除</a>
        </div>
        <!-- 表格数据 -->
        <table class="table">
            <thead>
            <tr>
                <th>序号</th>
                <th>课程图片</th>
                <th>课程名称</th>
                <th>课时</th>
                <th>所属学院</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course"  varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td height="20%"><img src="/images/${course.image}" width="40px" height="40px"></td>
                        <td>${course.name}</td>
                        <td>${course.hours}</td>
                        <c:if test="${course.schools == 1}">
                            <td>计算机学院</td>
                        </c:if>
                        <c:if test="${course.schools == 2}">
                            <td>外国语学院</td>
                        </c:if>
                        <td><a class="link" href="/course/update_page?id=${course.id}&name=${course.name}&hours=${course.hours}&schools=${course.schools}" >修改</a>&emsp;
                            <a class="link" href="/course/delete_solve?id=${course.id}" onclick="return confirm('你确定要删除此课程吗?——————三思而后行！！！');">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
    <script src="../static/js/main.js"></script>
</html>
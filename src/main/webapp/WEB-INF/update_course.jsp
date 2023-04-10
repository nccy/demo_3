<%--
  Created by IntelliJ IDEA.
  User: 长夜
  Date: 2023/4/1
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改课程</title>
    <link rel="stylesheet" href="../static/css/update_course.css" type="text/css">
    <style>
        .btn-exit {
            background-color: red;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            display: flex;
            justify-content: center;
            width: 50%; /* optional */
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
        }
        .btn-exit:hover {
            background-color: #ff2f2f;
        }
    </style>
</head>
<body>
    <form class="signup-form" action="/course/update_solve" method="post" enctype="multipart/form-data">
        <%--隐藏域，提交id--%>
        <input type="hidden" name="id" value="${course.id}">
        <h2 class="form-title">修改课程</h2>
        <div class="form-group">
            <label for="course-image">课程图片</label>
            <input type="file" accept="image/*" id="course-image" name="imageFile">
        </div>
        <div class="form-group">
            <label for="course-name">课程名称</label>
            <input type="text" id="course-name" name="name" required value="${course.name}">
        </div>
        <div class="form-group">
            <label for="course-hours">课时</label>
            <input type="number" id="course-hours" name="hours" required min="1" value="${course.hours}">
        </div>
        <div class="form-group">
            <label for="college">所属学院</label>
            <select id="college" name="schools" required >
                <option value="">请选择学院</option>
                <option value="1" ${course.schools eq 1 ? 'selected' : ''}>计算机学院</option>
                <option value="2" ${course.schools eq 2 ? 'selected' : ''}>外国语学院</option>
            </select>
        </div>
        <button type="submit" class="btn-submit">修改课程</button>
        <button type="button" class="btn-exit" id="btn-exit">退出</button>
    </form>
</body>
    <script src="../static/js/update_course.js"></script>
</html>

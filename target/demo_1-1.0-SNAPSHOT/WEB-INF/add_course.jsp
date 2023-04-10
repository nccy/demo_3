<%--
  Created by IntelliJ IDEA.
  User: 长夜
  Date: 2023/3/31
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>添加课程</title>
    <link rel="stylesheet" href="../static/css/add_course.css" type="text/css">
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
    <form class="signup-form" action="/course/add_solve" method="post" enctype="multipart/form-data">
        <h2 class="form-title">添加课程</h2>
        <div class="form-group">
            <label for="course-image">课程图片</label>
            <input type="file" accept="image/*" id="course-image" name="imageFile" >
        </div>
        <div class="form-group">
            <label for="course-name">课程名称</label>
            <input type="text" id="course-name" name="name" required>
        </div>
        <div class="form-group">
            <label for="course-hours">课时</label>
            <input type="number" id="course-hours" name="hours" required min="1">
        </div>
        <div class="form-group">
            <label for="college">所属学院</label>
            <select id="college" name="schools" required>
                <option value="">请选择学院</option>
                <option value="1">计算机学院</option>
                <option value="2">外国语学院</option>
            </select>
        </div>
        <button type="submit" class="btn-submit">添加课程</button>
        <button type="button" class="btn-exit" id="btn-exit">退出</button>
    </form>
</body>
    <script src="../static/js/add_course.js"></script>
</html>

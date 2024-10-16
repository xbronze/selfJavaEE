<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
</head>
<body>
<h2>添加学生信息</h2>
<form action="${pageContext.request.contextPath}/system/showInfor" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>学号：</td>
            <td><input type="text" name="number"><br></td>
        </tr>
        <tr>
            <td>姓名：<br></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年级：</td>
            <td><input type="text" name="grade"><br></td>
        </tr>
        <tr>
            <td>班级：</td>
            <td><input type="text" name="clbum"><br></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="text" name="gender"><br></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age"><br></td>
        </tr>
        <tr>
            <td>照片：</td>
            <td><input type="file" name="photo" multiple="multiple"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="添加">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

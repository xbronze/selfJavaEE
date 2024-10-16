<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/10/5
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>添加信息成功！</h2>
<table>
  <tr><td>学号：</td><td>${student.getNumber()}</td></tr>
  <tr><td>姓名：</td><td>${student.getName()}</td></tr>
  <tr><td>年级：</td><td>${student.getGrade()}</td></tr>
  <tr><td>班级：</td><td>${student.getClbum()}</td></tr>
  <tr><td>性别：</td><td>${student.getGender()}</td></tr>
  <tr><td>年龄：</td><td>${student.getAge()}</td></tr>

  <tr>
    <td>照片：</td>
    <td>
      <img src=" ${student.getRequestPath()}" width="100%" height="100%"/><br>
      <a href="${pageContext.request.contextPath}/system/downloadFile?fileName=${student.getPhotoName()}">
        单击下载照片</a>
    </td>
  </tr>
</table>
</body>

</html>

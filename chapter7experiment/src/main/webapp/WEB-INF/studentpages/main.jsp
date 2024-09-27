<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/27
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
</head>
<body>
<h1>系统主页</h1>
<tr>
    <td>账号：</td>
    <td>${user.getNumber()}<br></td>
</tr>
<tr>
    <td>身份：</td>
    <td>${user.getIdentity()}<br></td>
</tr>
<a href="${pageContext.request.contextPath}/user/logout">退出登录</a>

</body>
</html>

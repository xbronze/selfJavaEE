<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/27
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
</head>
<body>
<h1>欢迎来到登录页面！</h1>
<form action="${pageContext.request.contextPath}/user/loginCheck" method="post">
    <table>
        <tr>
            <td align="center" colspan="2" style="color: red">${msg}</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="number"><br></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"><br></td>
        </tr>
        <tr>
            <td>身份：</td>
            <td><input type="text" name="identity"><br></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>

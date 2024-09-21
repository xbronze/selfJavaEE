<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/21
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/system/loginCheck" method="post">
    账号:<input type="text" name="number"/><br/>
    密码:<input type="password" name="password"/><br/>
    身份:<input type="text" name="identity"/><br/>
    <input type="submit" value="登录"/>
  </form>
</body>
</html>

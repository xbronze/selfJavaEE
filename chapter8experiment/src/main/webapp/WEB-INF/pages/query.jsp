<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/21
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
  <h1>查询页面</h1>
  <table>
    <tr>
      <td>学号：</td><td><input type="text" name="number"><br></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="button" value="查询信息">
        <input type="button" value="查询成绩">
        <input type="button" value="返回"
               onclick="window.location.href='${pageContext.request.contextPath}/system/main'">
      </td>
    </tr>
  </table>

</body>
</html>

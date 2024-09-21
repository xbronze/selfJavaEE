<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>学生管理系统</title>
    </head>
    <body>
        <h1>系统主页</h1>
        <table>
            <tr><td>身份：</td><td>${user.getIdentity()}<br></td></tr>
            <tr><td>账号：</td><td>${user.getNumber()}<br></td></tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="button" value="查询"
                           onclick="window.location.href='${pageContext.request.contextPath}/system/query'">
                    <input type="button" value="添加"
                           onclick="window.location.href='${pageContext.request.contextPath}/system/add'">
                </td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/system/logout">退出登录</a>

    </body>
</html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>学生管理系统</title>
    </head>
    <body>
        <h1>欢迎使用学生管理系统！</h1>
        <form action="${pageContext.request.contextPath}/user/login" method="get">
            <table style="text-align: center">
                <tr>
                    <td colspan="2">
                        <input type="submit" value="登录">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
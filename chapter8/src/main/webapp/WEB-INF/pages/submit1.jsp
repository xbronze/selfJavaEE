<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>问卷调查</title>
    </head>
    <body>
        <h2>问卷调查</h2>
        <form action="${pageContext.request.contextPath}/interceptor/check" method="get">
            <table>
                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="age"><br></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input type="text" name="gender"><br></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
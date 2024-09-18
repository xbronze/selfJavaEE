<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>问卷调查</title>
    </head>
    <body>
        <h2>问卷调查</h2>
        <form action="${pageContext.request.contextPath}/response3/returnPage" method="post">
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
                    <td>爱好：</td>
                    <td>
                        <input type="checkbox" name="hobbies" value="阅读">阅读<br>
                        <input type="checkbox" name="hobbies" value="电影">电影<br>
                        <input type="checkbox" name="hobbies" value="运动">运动<br>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
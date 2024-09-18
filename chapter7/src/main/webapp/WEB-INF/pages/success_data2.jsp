<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>问卷调查</title>
    </head>
    <body>
    <h2>提交调查问卷成功！</h2>
    <table>
        <tr><td>年龄：</td><td>${questionary.getAge()}</td></tr>
        <tr><td>性别：</td><td>${questionary.getGender()}</td></tr>
        <tr>
            <td>爱好：</td>
            <c:forEach items="${questionary.getHobbies()}" var="hobby">
                <td>${hobby}</td>
            </c:forEach>
        </tr>
    </table>
    </body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/10
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Git仓库</title>
        <style>
            table, th, td {
                border: 1px solid black; /* 设置实线边框 */
                border-collapse: collapse; /* 移除单元格之间的间隔 */
            }
        </style>
    </head>
    <body>
        <div>
            <h2>Git仓库列表</h2>
            <form action="${pageContext.request.contextPath}/git/queryByCode" method="post">
                学号：<input type="text" name="code" value="${param.code}">
                <input type="submit" value="查询"></td>
            </form>
            <table>
                <tr>
                    <td>ID</td>
                    <td>班级</td>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>仓库地址</td>
                </tr>
                <c:if test="${not empty gitInfoList}">
                    <c:forEach items="${gitInfoList}" var="gitInfo" varStatus="status">
                        <tr>
                            <td>${gitInfo.id}</td>
                            <td>${gitInfo.classes}</td>
                            <td>${gitInfo.code}</td>
                            <td>${gitInfo.name}</td>
                            <td>${gitInfo.gitAddress}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
        <div style="margin-top: 30px">
            <form action="${pageContext.request.contextPath}/git/add" method="post">
                班级：<input type="text" name="classes">
                学号：<input type="text" name="code">
                姓名：<input type="text" name="name">
                仓库地址：<input type="text" name="gitAddress">
                <input type="submit" value="添加">
            </form>
        </div>
    </body>
</html>

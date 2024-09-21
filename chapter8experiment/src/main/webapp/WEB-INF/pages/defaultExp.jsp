<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/21
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<title>权限验证提示页面</title>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td align="center" colspan="2" style="color: red">
            ${exp.getMessage()}
        </td>
    </tr>
    <c:if test='${fn:contains(exp.getMessage(),"未登录")}'>
        <tr>
            <td colspan="2" align="center">
                <input type="button" value="返回"
                       onclick="window.location.href='${pageContext.request.contextPath}/system/login'">
            </td>
        </tr>
    </c:if>
    <c:if test='${fn:contains(exp.getMessage(),"添加")}'>
        <tr>
            <td colspan="2" align="center">
                <input type="button" value="返回"
                       onclick="window.location.href='${pageContext.request.contextPath}/system/main'">
            </td>
        </tr>
    </c:if>
</table>

</body>
</html>

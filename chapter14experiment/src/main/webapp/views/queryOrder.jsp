<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/9/10
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>订单查询</title>
</head>
<body>
    <h2>订单查询</h2>
    <form action="${pageContext.request.contextPath}/order/queryOrderByNum" method="get">
        <table>
            <tr>
                <td>订单编号：</td>
                <td><input type="text" name="number" value="${order.number}">
                </td>
                <td><input type="submit" value="查询"></td>
            </tr>
        </table>
    </form>
    <table>
    <c:if test="${not empty order}">
        <tr>
            <td width="100">订单编号</td>
            <td width="80">会员id</td>
            <td width="100">商品名</td>
            <td width="60">数量</td>
            <td width="60">金额</td>
        </tr>
        <tr>
        <td width="100">${order.number}</td>
            <td width="80">${order.id}</td>
            <td width="100">${order.name}</td>
            <td width="60">${order.count}</td>
            <td width="60">${order.money}</td>
        </tr>
    </c:if>
    </table>

</body>
</html>

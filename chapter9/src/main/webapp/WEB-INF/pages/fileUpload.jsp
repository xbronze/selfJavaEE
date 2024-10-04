<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>文件上传</title>
</head>
<body>
<table border="1">
  <tr>
    <td width="500" align="center">文件上传</td>
  </tr>
  <tr>
    <td>
      <form action="${pageContext.request.contextPath}/file/upload"
            method="post" enctype="multipart/form-data">
        <input type="file" name="uploadfiles" multiple="multiple"/><br>
        <input type="submit" value="上传"><br>
      </form>
    </td>
  </tr>
  <c:forEach items="${msgs}" var="msg">
    <tr><td align="center" colspan="2" style="color: red">${msg}</td></tr>
  </c:forEach>
</table>
</body>
</html>

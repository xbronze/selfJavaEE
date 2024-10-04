<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>文件下载</title>
</head>
<body>
<table border="1">
  <tr>
    <td width="350" align="center">下载列表</td>
  </tr>
  <tr>
    <td>
      <a href="${pageContext.request.contextPath}/file/download?fileName=兰亭集序.txt">兰亭集序.txt</a><br>
      <a href="${pageContext.request.contextPath}/file/download?fileName=春天.jpeg">春天.jpeg</a><br>
      <a href="${pageContext.request.contextPath}/file/download?fileName=秋天.jpeg">秋天.jpeg</a><br>
    </td>
  </tr>
</table>
</body>
</html>

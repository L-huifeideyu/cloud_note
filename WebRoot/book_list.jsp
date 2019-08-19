<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<table>
	<tr>
		<td>笔记本名</td>
		<td>创建时间</td>
		<td>所属用户</td>
	</tr>
	<c:forEach items="${result.data}" var="book">
		<tr>
		<td>${book.cn_notebook_name }</td>
		<td>${book.cn_notebook_createtime }</td>
		<td>${book.user.cn_user_name }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>




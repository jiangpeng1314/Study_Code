<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>转账账号</td>
		<td>收款账号</td>
		<td>转账金额</td>
	</tr>
	<c:forEach items="${pageInfo.list}" var="log" >
	<tr>
		<td>${log.accOut }</td>
		<td>${log.accIn }</td>
		<td>${log.money }</td>
	</tr>
	</c:forEach>
</table>
<a href="LogServlet?pageSize=${pageinfo.pageSize }&pageNumber=${pageInfo.pageNumber-1}" <c:if test="${pageInfo.pageNumber<=1 }"> onclick="javascript:return false;"</c:if>>上一页</a>
<a href="LogServlet?pageSize=${pageinfo.pageSize }&pageNumber=${pageInfo.pageNumber+1}" <c:if test="${pageInfo.pageNumber>=pageInfo.total }"> onclick="javascript:return false;"</c:if>>下一页</a>

</body>
</html>
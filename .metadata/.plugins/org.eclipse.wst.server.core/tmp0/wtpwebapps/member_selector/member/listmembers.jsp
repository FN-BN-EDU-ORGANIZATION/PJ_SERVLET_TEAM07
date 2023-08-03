<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.cls1{
		font-size: 40px;
		text-align: center;
	}
	
	.cs2{
		font size: 20px;
		text-align: center;
	}
</style>
</head>
<body>
	<p class="cls1">회원정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="%"><b>아이디</b></td>
			<td width="%"><b>비밀번호</b></td>
			<td width="%"><b>이름</b></td>
			<td width="%"><b>이메일</b></td>
			<td width="%"><b>가입일</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty membersList}">
				<td colspan="5" align="center">
					<b>등록된 회원이 없습니다.</b>
				</td>		
			</c:when>
			<c:when test="${not empty membersList }">
				<c:forEach var="mem" items="${membersList }">
					<tr align="center">
						<td>${mem.id }</td>
						<td>${mem.pwd }</td>
						<td>${mem.name }</td>
						<td>${mem.email }</td>
						<td>${mem.joinDate }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>		
</body>
</html>
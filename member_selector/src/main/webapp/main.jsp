<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/mem.do" method="get">
		<input type="submit" value="모든회원조회" id="get">
		<script>
			const get_button=document.getElementById("get");
			get_button.addEventListener("click", function(){
				window.location.href="./webapp/member/listmember.jsp"
			})
		</script>
	</form>
</body>
</html>
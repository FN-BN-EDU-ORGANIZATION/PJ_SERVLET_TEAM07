<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr />
<h1>Welcome to BookSearch Service</h1>

<hr />
<form action="" method="post">
ID : <input name="id" /><br />
PW : <input name = "pw" type="password" /><br />
<input type="submit" value="login" />
<a href="${pageContext.request.contextPath }/Join.do">회원가입</a>
</form>
<hr />

<div class="msg"> 
	${msg}
</div>


</body>
</html>
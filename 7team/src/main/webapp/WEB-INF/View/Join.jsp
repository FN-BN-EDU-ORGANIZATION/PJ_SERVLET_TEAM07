<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
	ID : <input name="id" /><br />
	PW : <input type="password" name="pw" /><br />
	NAME : <input name="name" /><br />
	PHONE : <input name="tel" /><br />
	ADDRESS : <input name="addr" /><br />
	Role : <input type="radio" name="role" value="member" checked="chedked"/>
		   <input type="radio" name="role" value="admin"/><br />
	<input type="submit" name="가입하기"/><a href="">뒤로가기</a>
	</div>
</body>
</html>
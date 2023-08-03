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
	<form action="${pageContext.request.contextPath}/Join.do" method="post" >
	ID : <input name="id" /><br />
	PW : <input type="password" name="pw" /><br /> 
	NAME : <input name="name" /><br />
	PHONE : <input name="tel" /><br />
	ADDRESS : <input name="addr" /><br />
	Role : <input type="radio" name="role" value="member" checked="chedked"/>
		   <input type="radio" name="role" value="admin"/><br />
	<input type="submit" name="가입하기" onclick="isValid()"/><a href="javascript:history.go(-1)">뒤로가기</a>
	</form>
	
	<script defer>
	/* 자바스크립트 수준의 유효성 체크  */
	const isValid=function(){
		const joinfrm = document.joinfrm;
		//alert("[JS] func isValid");
		//email 공백여부 등 Validation Check

		joinfrm.submit();
	}
</script>


</body>
</html>
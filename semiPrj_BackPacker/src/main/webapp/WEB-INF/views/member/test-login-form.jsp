<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>

		<div>
			
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		</div>
	<div>
		<br><br><br><br><br><br>
		
		<c:if test="${ empty loginMember }">
			<form action="${pageContext.request.contextPath}/test/login" method="post">
				<input type = "text" name = "memberId" placeholder="아이디">
				<input type = "password" name = "memberPwd" placeholder="비밀번호">
					  <input type = "submit" id = "login-btn" value= "로그인">
					</form>
					<button type="submit">로그인</button>
				</c:if>
			</div>
		</div>
</body>
</html>
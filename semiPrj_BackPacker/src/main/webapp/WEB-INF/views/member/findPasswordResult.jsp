<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 확인 결과 페이지</title>
<style type="text/css">
	
	main > #wrap {
		margin: auto;
		margin-top: 10%;
		width: 600px;
		height: 500px;
	}
	
	#button-area {
		display: flex;
		flex-direction: row;
		justify-content: space-around;
		width: 100%;
		height: 50px;
		
	}
	
	.button-style {
		border-radius: 5px;
		width: 130px;
		height: 30px;
		background-color: #94d2e6;
		color: white;
		border: none;
	}
	
	span {
		margin-left: 5%;
		font-size: 35px;
		
	}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<div id="wrap">
			<div id="result-area">
			<c:if test="${not empty tempMember}">
				<span>${tempMember.nick}님의 비밀번호는 ${tempMember.password}입니다.</span>
			</c:if>
			<c:if test="${empty tempMember}">
				<span>입력하신 정보가 없습니다.</span>
			</c:if>
		</div>
		<br>
		<div id="button-area">
			<button class="button-style" id="join-btn">회원가입</button>
			<button class="button-style" id="login-btn">로그인</button>
			<button class="button-style" id="id-find-btn">아이디 찾기</button>
			<c:if test="${empty tempMember}">
				<button class="button-style" id="back-btn">이전으로</button>
			</c:if>
		</div>
		</div>
	</main>
	
	<script>
		const joinBtn = document.querySelector("#join-btn");
		const loginBtn = document.querySelector("#login-btn");
		const idFindBtn = document.querySelector("#id-find-btn");
		const backBtn = document.querySelector("#back-btn");
		
		joinBtn.addEventListener("click", function(){
			location.href = "${root}/member/join";
		});

		loginBtn.addEventListener("click", function(){
			location.href = "${root}/member/login";
		});

		idFindBtn.addEventListener("click", function(){
			location.href = "${root}/member/find/id";
		});
		
		backBtn.addEventListener("click", function(){
			history.back();
		});

	</script>
	
</body>
</html>
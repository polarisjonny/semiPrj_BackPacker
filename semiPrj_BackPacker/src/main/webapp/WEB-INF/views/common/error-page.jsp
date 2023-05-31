<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	main {
		margin-top: 10%;
	}

	#alert-area {
		
		margin: auto;
		/* border: 1px solid #94d2e6; */
		width: 800px;
		height: 500px;
		text-align: center;
	}
	
	.alert-btn {
		background-color: #94d2e6;
		color: white;
		width: 120px;
		height: 40px;
		font-weight: bold;
		text-decoration: none;
		display: inline-block;
		margin-right: 10px;
		line-height: 40px;
		border-radius: 5px;
	}

	.btn:last-child {
		margin-right: 0;
	}
</style>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<div id="alert-area">
				<hr>
				<br>
				<br>
				<img width="100" height="100" alt="" src="${root}/static/img/logo/alert.png">
				<br>
				<br>
				<br>
				<br>
				<h1>${errorMsg}</h1>
				<br>
				<br>
				<a class="alert-btn" href="javascript:void(0);" onclick="goBack()">이전 화면</a>
				<a class="alert-btn" href="javascript:void(0);" onclick="goHome()">홈으로</a>
				<br>
				<br>
				<br>
				<br>
				
				<hr>
			</div>
		</main>
	
	</div>

</body>
</html>
			

<script>
	function goBack() {
	  history.back();
	}
	
	function goHome() {
		location.href="${root}/home";
	}
</script>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
		
			<br><br><br><br><br><br><br><br><br><br>
			<h1>${errorMsg}</h1>
			<a href="javascript:void(0);" onclick="goBack()">이전 화면으로</a>







		
		</main>
	
	</div>

</body>
</html>
			

<script>
function goBack() {
  history.back();
}
</script>


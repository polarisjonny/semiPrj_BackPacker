<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<!-- 폰트어썸 cdn -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	#wrap {
		padding-top: 200px;
		margin : auto;
		width : 800px;
		height: 100px;
		display: flex;
		flex-direction: column;
		align-items: center;
		
	}
	#big-txt {
		margin-top: 15px;
		font-size: 1.4em;
		width: 600px;
		text-align: left;
		font-weight: 700;
	}
	#input-area {
		margin-top: 15px;
	}

	#input-area > input{
		width: 600px;
		border: none;
		border-bottom: 1px solid black;
		outline: none;
		font-size: 16px;
		
	}
	

	textarea {
		width: 600px;
		height: 300px;
		line-height: 25px;
		outline: none;
	}
	#btn {
		width: 600px;
	}

	#btn > input {
		float: right ;
		font-size: 17px;
	}
	
</style>
</head>
<body>
	
		<div id="wrap">
			<input type="hidden" name="no" value="${gbvo.guideBoardNo}">
			<div id="big-txt">
			신고내용을 적어주세요.
			</div>
			<div>
			<textarea name="content" style="resize: none;"></textarea>
			</div>
			<div id="btn">
				<input type="submit" class="report-btn"  value="신고하기">
			</div>
		</div>
</body>
</html>
<script>

	//데이터수정 및 부모창새로고침하고 클로즈
	const reportBtn = document.querySelector(".report-btn");
	reportBtn.addEventListener("click",function(){
		const content = document.querySelector("textarea").value;
		const no = document.querySelector("input[name=no]").value;

		$.ajax({
			url : "${root}/accompany/report",
			type : "post",
			data : {
				content : content,
				no : no,
			},
			success : (x)=>{
				if(x=='ok'){
					alert("신고가 접수되었습니다.");
					setTimeout(()=>{
						window.close();
					},1000)
				}else if(x=='constraint'){
					alert("이미 한번 신고한 게시글 입니다.");
					setTimeout(()=>{
						window.close();
					},1000)
				}else{
					alert("신고 실패, 관리자에게 문의하세요.");
					setTimeout(()=>{
						window.close();
					},1000)
				}
			},
			error : (e)=>{
				alert(e+":관리자에게 문의하세요.");
				setTimeout(()=>{
						window.close();
				},1000)
			},
		});	
	});
</script>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	#wrap {
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

	textarea {
		width: 600px;
		height: 600px;
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
	
	#btn > .answer-btn{
		border-radius: 10px;
	    border: 1px solid #99ccff;
	    background-color:  #99ccff;
	    color:white;
	    padding:10px;
	}
</style>
</head>
<body>

	<div id="wrap">
		<input type="hidden" name="qnaNo" value="${vo.qnaNo}">
			<div id="big-txt">
			답변 달기
			</div>
			<div>
			<textarea name="answer" style="resize: none;"></textarea>
			</div>
			<div id="btn">
				<input type="submit" class="answer-btn"  value="완료">
			</div>
		</div>


		<script>

			const Btn = document.querySelector('.answer-btn')

			Btn.addEventListener('click' , function (params) {
				
				const qnaNo = document.querySelector('input[name=qnaNo]').value;
				const answer = document.querySelector('textarea[name=answer]').value;
				$.ajax({
					url : '${root}/notice/inquiryQnaAnswer',
					type : 'post',
					data : {
						qnaNo : qnaNo,
						answer : answer,
					},
					success : function(data) {
						if(data ="ok"){
							window.opener.parent.location.reload();
							alert('답변달기 완료')
							setTimeout(() => {
								window.close();
							}, 1000);
						}else{
							alert('답변달기 실패')
							setTimeout(() => {
								window.close();
							}, 1000);
						}
					},
					error : function(e) {
						console.log(e);
					},
				})
			})
		</script>
</body>
</html>
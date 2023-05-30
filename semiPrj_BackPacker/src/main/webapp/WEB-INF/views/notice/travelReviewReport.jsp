<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
	<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- alert창 꾸미기 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<input type="hidden" name="no" value="${vo.infoNo}">
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

		<script>
			const reportBtn = document.querySelector('.report-btn');
			reportBtn.addEventListener('click' , function (params) {
				
				const infoNo = document.querySelector('input[name=no]').value;
				const content = document.querySelector('textarea').value;
				
				$.ajax({
					url : '${root}/notice/report',
					type : 'post',
					data : {
						infoNo : infoNo,
						content : content,
					},
					success : function(x) {
						if(x=='ok'){
							Swal.fire({
								title : '신고를 접수하였습니다.',
								icon: 'success',
		                        text: '',
							})
							setTimeout(() => {
								window.close();
							}, 1300);
						}else{
							Swal.fire({
								title : '신고를 접수할수 없습니다.',
								icon: 'warning',
		                        text: '중복 신고는 불가능합니다'
							})
							setTimeout(() => {
								window.close();
							}, 1300);
						}
						
					},
					
					error : function(e) {
						alert('신고실패.. 관리자에게 문의하세요');
						setTimeout(() => {
							window.close();
						}, 1000);
					},
	
				})
			});
		</script>
</body>
</html>
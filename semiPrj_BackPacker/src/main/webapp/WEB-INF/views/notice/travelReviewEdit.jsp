<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- 폰트어썸 -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
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
	#left {
		float: left;
	}
</style>
</head>
<body>

	<div id="wrap">
			<input type="hidden" name="no" value="${vo.infoNo}">
			<div id="big-txt">
			제목 수정하기
			</div>
			<div id="input-area">
			<input type="text" name="title" value="${vo.title}">
			</div>
			<div id="big-txt">
			내용 수정하기
			</div>
			<div>
			<textarea name="content" style="resize: none;">${vo.content}</textarea>
			</div>
			<div id="btn">
				<div id="left"><i class="fa-solid fa-circle-info fa-lg" style="color: #94D2E6;"></i>자기소개는 마이페이지에서 변경할 수 있습니다.</div>
				<input type="submit" class="edit-btn"  value="수정하기">
			</div>
		</div>

		<script>
			const editBtn = document.querySelector('.edit-btn');

			editBtn.addEventListener('click' , function() {
				const infoNo = document.querySelector('input[name=no]').value;
				const title = document.querySelector('input[name=title]').value;
				const content = document.querySelector('textarea').value;
				
				$.ajax({
					url :'${root}/notice/reviewEdit',
					type :'post',
					data : {
						title : title,
						infoNo : infoNo,
						content : content,
					},
					success : function (x) {
						if(x=='ok'){
							window.opener.parent.location.reload();
							alert('수정완료되었습니다.')
							setTimeout(() => {
								window.close();
							}, 1000);
						}else{
							alert('수정실패하였습니다.')
						setTimeout(() => {
							window.close();
						}, 1000);
						}
					},
					error : function(e) {
						alert(e+"관리자에게 문의하세요.")
						setTimeout(() => {
							window.close();
						}, 1000);
					},
					
				});
				
			})

		</script>


</body>
</html>
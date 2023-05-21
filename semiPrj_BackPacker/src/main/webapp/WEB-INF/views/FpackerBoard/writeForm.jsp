<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  썸머노트를 사용하기 위한 제이쿼리 -->
<!-- include libraries(jQuery, bootstrap) -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main-box {
		margin-top: 100px;
		display: grid;
		grid-template-columns: 1.5fr 3fr 1.5fr;
		height: 100%;
	}
	#imgFile {
		visibility: hidden;
	}
	#big-text {
		font-size: 30px;
		font-weight: 700;
		margin-bottom: 10px;
	}
	#imgUpload {
		display: flex;
		flex-direction: column;
		width: 100%;
		height: 400px;
		justify-content: center;
		align-items: center;
		background-color: lightgray;
	}

	#title-area {
		margin-top: 10px;
		margin-bottom: 10px;
	}
	#title-area > input{
		padding: 5px;
		border: 1px solid #979797;
		border-radius: 5px;
		width: 100%;
		height: 35px;
	}
	#submit {
		background-color: #94D2E6;
		border: none;
		width: 130px;
		height: 50px;
		border-radius:10px;
		color: white;
		font-size: 1.3em;
		font-weight: 700;
		float: right;
	}

</style>
</head>
<body>
	<main>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div id="main-box">
		<div class="main-blank"></div>
		<div id="main-area">
			<div id="big-text">프패커합니다 게시글 작성</div>
			<form action="" method="post" enctype="multipart/form-data">
				<div id="imgUpload">
					<label for="imgFile">
						썸네일 사진 올리기
					</label>
					<input type="file" id="imgFile">
				</div>
				<div id="title-area">
					<input type="text" id="title"placeholder="제목을 20자 이내로 적어주세요.">
				</div>
				<div id="text-area">
					<textarea id="summernote" name="editordata"></textarea>
					<script>
						$(document).ready(function() {
  							$('#summernote').summernote();
						});

						$('#summernote').summernote({
  							height: 500,                 // set editor height
 							focus: false                  // set focus to editable area after initializing summernote	
						});
					</script>
				</div>
				<input id="submit" type="submit" value="작성완료">
			</form>	
		</div>
		<div class="main-blank"></div>
	</div>
		
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</main>
</body>
</html>
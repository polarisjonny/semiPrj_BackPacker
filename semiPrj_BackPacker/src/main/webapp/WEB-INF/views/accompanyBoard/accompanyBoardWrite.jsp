<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  

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
	#submit-btn {
		background-color: #94D2E6;
		border: none;
		width: 130px;
		height: 50px;
		border-radius:10px;
		color: white;
		font-size: 1.3em;
		font-weight: 700;
		
	}
	textarea {
		width: 100%;
		height: 300px;
	}
	
</style>
</head>
<body>
	<main>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
	<div id="main-box">
		<div class="main-blank"></div>
		<div id="main-area">
			<div id="big-text">동행게시판 게시글 작성</div>
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
				<div id="content-area">
					<textarea name="content" placeholder="내용을 입력해주세요"></textarea>
					<input id="submit-btn" type="submit" value="작성완료">				
				</div>
			</form>	
		</div>
		<div class="main-blank"></div>
	</div>
		
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</main>
</body>
</html>

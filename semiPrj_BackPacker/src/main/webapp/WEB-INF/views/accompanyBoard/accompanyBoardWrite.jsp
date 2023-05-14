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
		float: right;
		margin-top: 10px;
	}
	textarea {
		width: 100%;
		height: 300px;
	}
	.travel-date-area {
		display: grid;
		grid-template-columns: 0.8fr 1.6fr 0.8fr 1.6fr;
		
	}
	.travel-date-area > input:nth-child(2) {
		width: 240px;
	}
	/* 썸네일 올리는 영역 css */
	#imgFile {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	#imgFile > input {
		display: none;
	}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	
		
	<div id="main-box">
		<div class="main-blank"></div>
		<div id="main-area">
			<div id="big-text">동행게시판 게시글 작성</div>
			<form action="${root}/accompany/write" method="post" enctype="multipart/form-data">
				<div id="imgUpload">
					<label id="imgFile">
						<div>썸네일 사진 올리기</div> 
						<input type="file" id="imgFile" name="boardListThumbnail">
					</label>
				</div>
				<div id="title-area">
					<input type="text" name="title"placeholder="제목을 20자 이내로 적어주세요.">
				</div>
				<div id="content-area">
					<textarea name="content" style="resize: none;" placeholder="내용을 입력해주세요"></textarea>		
				</div>
				<div class="travel-date-area">
					<div>시작날짜</div>
					<input type="date" name="startDate">
					
					<div>종료날짜</div>
					<input type="date" name="endDate">
				</div>
				<input id="submit-btn" type="submit" value="작성완료">	
			</form>	
		</div>
		<div class="main-blank"></div>
	</div>
		
	<script>
		const fileTag = document.querySelector("input[type=file]");
		const imgUpload = document.querySelector("#imgUpload");

		fileTag.onchange = function(e){
			const fr = new FileReader();
			fr.readAsDataURL(fileTag.files[0]);

			fr.onload = function(e){
				imgUpload.setAttribute('background-image',url(e.target.result));
	


			}
		}

	</script>
	
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>

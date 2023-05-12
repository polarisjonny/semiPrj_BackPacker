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
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
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
				<div id="summernote"></div>
			    <script>
			      $('#summernote').summernote({
			        placeholder: 'Hello stand alone ui',
			        tabsize: 2,
			        height: 120,
			        toolbar: [
			          ['style', ['style']],
			          ['font', ['bold', 'underline', 'clear']],
			          ['color', ['color']],
			          ['para', ['ul', 'ol', 'paragraph']],
			          ['table', ['table']],
			          ['insert', ['link', 'picture', 'video']],
			          ['view', ['fullscreen', 'codeview', 'help']]
			        ]
			      });
			    </script>
				<input id="submit" type="submit" value="작성완료">
			</form>	
		</div>
		<div class="main-blank"></div>
	</div>
		
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</main>
</body>
</html>

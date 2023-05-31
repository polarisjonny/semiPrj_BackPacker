<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<title>Insert title here</title>
<style>
	main{
		margin-top: 66px;
		padding: 0px;
		width:100%;
		height: 1100px; 
	}
	
	#travelInformationWrite{
		background-color:white;
		height:900px;
		width: 60%;
		margin:auto;
		display:flex;
		flex-direction: column;
		justify-content:space-evenly;
	}
	
	#InformationWrite{
		font-size: 2em;
		margin-top:66px;
	}
	
	#imgUpload{
		border: 1px solid lightgray;
		box-sizing: border-box;
		display:flex;
		justify-content:center;
		align-items:center;
		height:300px;
		width:90%;
		background-color:lightgray;
	}
	
	
	label{
		cursor: pointer;
		font-size:1.4em;
		margin-left:90px;
	}
	
	#imgFile{
		visibility: hidden;
		width:80px;
	}
	
	#title{
		border:1px solid lightgray;
		border-radius: 5px;
		width:90%;
		margin-top:10px;
		margin-bottom:10px;
		height:30px;
	}
	
	#content{
		border:1px solid lightgray;
		margin-top:10px;
		width:90%;
		height:450px;
	}
	
	.note-editor{
		width:90%;
	}
	
	#submit{
		display:flex;
		justify-content: flex-end;
	}
	
	#submit > input{
		margin-right:80px;
        border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        height:40px;
        color:white;
        margin-top:10px;
		width:120px;
    }
</style>
</head>
<body>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
     <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	
		<main>
		
		<div id="travelInformationWrite">
		
			<div id="InformationWrite">여행정보 게시글 작성</div>

				<form action="" method="post" enctype="multipart/form-data">
				<div id="imgUpload">
						<label for="imgFile">
							대표 사진 올리기
						</label>
						<input type="file" id="imgFile">
				</div>
						<input type="text" id="title"placeholder="제목을 20자 이내로 적어주세요." maxlength="20">
						<br>
						
						<textarea class="summernote" name="editordata" style="resize:none;" ></textarea>
						
						<div id="submit">
							<input type="submit" value="작성 완료">
						</div>
				</form>

			

		</div>
		
		</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		
		 <script>
               $('.summernote').summernote({
                 placeholder: 'Hello stand alone ui',
                 tabsize: 2,
                 height: 450,
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

</body>
</html>
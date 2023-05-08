<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	}
	
	#content{
		border:1px solid lightgray;
		margin-top:10px;
		width:90%;
		height:450px;
	}
	
	#subMit{
        border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        height:40px;
        width:15%;
        color:white;
        margin-left:650px;
        margin-top:10px;
    }
</style>
</head>
<body>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
		
		<div id="travelInformationWrite">
			<br>
			<br>
		
			<div id="InformationWrite">여행정보 게시글 작성</div>
			<br>
				<form action="" method="post" enctype="multipart/form-data">
				<div id="imgUpload">
						<label for="imgFile">
							대표 사진 올리기
						</label>
						<input type="file" id="imgFile">
				</div>
						<input type="text" id="title"placeholder="제목을 20자 이내로 적어주세요.">
						<br>
						<textarea id="content" name="content" style="resize:none;" ></textarea>
						
						<input id="subMit" type="submit" value="작성 완료">
				</form>

			

		</div>
		
		</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

</body>
</html>
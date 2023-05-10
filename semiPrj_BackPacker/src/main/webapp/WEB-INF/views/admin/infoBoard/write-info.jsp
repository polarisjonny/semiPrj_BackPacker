<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- 폰트어썸 cdn -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>
    <c:set var="root" value = "${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#infoMain{
		margin-top: 66px;
		padding: 0px;
		width:100%;
		height: 1100px; 
	}
	
	#travelInfoWrite{
		background-color:white;
		height:900px;
		width: 60%;
		margin:auto;
		display:flex;
		flex-direction: column;
		justify-content:space-evenly;
	}
	
	#infoWrite{
		font-size: 2em;
	}
	
	#infoimgUpload{
		border: 1px solid lightgray;
		box-sizing: border-box;
		display:flex;
		justify-content:center;
		align-items:center;
		height:300px;
		width:90%;
		background-color:lightgray;
	}
	
	
	#infoLabel{
		cursor: pointer;
		font-size:1.4em;
		margin-left:90px;
	}
	
	#infoimgFile{
		visibility: hidden;
		width:80px;
	}
	
	#infotitle{
		border:1px solid lightgray;
		border-radius: 5px;
		width:90%;
		margin-top:10px;
	}
	
	#infocontent{
		border:1px solid lightgray;
		margin-top:10px;
		width:90%;
		height:450px;
	}
	
	#infosubMit{
        border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        height:40px;
        width:15%;
        color:white;
        margin-top:10px;
    }

	
	
</style>
</head>
<body>

	
	
	<main id="infoMain">
	
		<div id="travelInfoWrite">
			<br>
			<br>
		
			<div id="infoWrite">여행정보 게시글 작성</div>
			<br>
				<form action="" method="post" enctype="multipart/form-data">
				<div id="infoimgUpload">
						<label id="infoLabel" for="imgFile">
							썸네일 사진 올리기
						</label>
						<input type="file" id="infoimgFile">
						<input type="text" value="${loginMember.memberNo}" name = "writerNo" hidden>
				</div>
						<input type="text" id="infotitle"placeholder="제목을 20자 이내로 적어주세요.">
						<br>
						<textarea id="infocontent" name="content" style="resize:none;" ></textarea>
						
						<input id="infosubMit" type="submit" value="작성 완료">
				</form>

			

		</div>
		
		
		
	</main>
	


</body>
</html>
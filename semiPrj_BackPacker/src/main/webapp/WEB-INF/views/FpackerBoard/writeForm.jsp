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
	#imgUpload {
		background-color: lightgray;
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
		height: 450px;
		position: relative;
	}
	#Thumnail{
		top: 50%;
		left: 50%;
		position: absolute;
		transform: translate(-50%,-50%);
		display: flex;
		flex-direction: column;
		text-align: center;

	}
	#imgFile{
		visibility: hidden;
	}
	#Thum-parent {
		width: 100%;
		height: 450px;
		position: relative;
	}
	#addInput-area {
		width: 100%;
		margin-top: 15px;
		display: flex;
		justify-content: flex-end;
		align-items: center;

		
	}

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	
		
	<div id="main-box">
		<div class="main-blank"></div>
		<div id="main-area">
			<div id="big-text">프패커게시판 게시글 작성</div>
			게시판을 선택해주세요.
			<select id="category" name="categoryValue">
				<option value="1">프패커합니다</option>
				<option value="2">프패커구해요</option>
			</select>
			<form action="${root}/Fpacker/write" method="post" enctype="multipart/form-data">
				<div id="Thum-parent">
					<img id="imgUpload">
					<div id="Thumnail">
						<label id="upload" for="imgFile">
							썸네일 사진 올리기 
						</label>
						<input type="file" id="imgFile" name="boardListThumbnail">
					</div>

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
				<div id="addInput-area">
					<input type="number">원
				</div>
				<div>
					<input id="submit-btn" type="submit" value="작성완료">	
				</div>
				
			</form>	
		</div>
	</div>
		
	
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const fileTag =document.querySelector("#imgFile");
	const Thumnail = document.querySelector("#Thumnail");
	const preview = document.querySelector("#imgUpload");

	fileTag.addEventListener('change',function(params){
		if(fileTag.files.length>0){
			const fr = new FileReader();
			fr.readAsDataURL(fileTag.files[0]);
			
			fr.addEventListener("load",function(event){
				preview.src = event.target.result;
				preview.width ="100%"
				preview.height ="100%"
				// Thumnail.style.visibility='hidden';
			});
		}else {
		preview.src ="";
		}
	})
	//카테고리가 프패커합니다면 아래 금액인풋태그가 보이게
	const categoryValueTag = document.querySelector("select[name=categoryValue]");
	const inputArea = document.querySelector("#addInput-area")
	categoryValueTag.addEventListener("change",function(){
		if(categoryValueTag.value ==2){
			inputArea.style.visibility = 'hidden';
		}else {
			inputArea.style.visibility = 'visible';
		}

	});
	

</script>

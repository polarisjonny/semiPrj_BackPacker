<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	main{
		margin: 0px;
		padding: 0px;
		width:100vw;
		height: 100vh;
	}
	


	#left {
		width: 73vw;
		height: 100vh;

		overflow: hidden;
	}
	#right{
		width: 27vw;
		height: 100vh;

	}
	
	#left > img {
		overflow: hidden;

	}

	#right{
		display: flex;
		flex-direction: column;
		justify-content: center;
	}
	#right > div {
		margin: 20px;
		/* border: 1px solid black; */
	}
	#big-text {
		font-size: 60px;
		text-align: center;
	}
	#btn-area {
		text-align: center;
		
	}
	#packer-btn {
		border: none;
		width: 161.63px;
		display: inline-block;
		padding: 15px 30px;
		border-radius: none;
		background-color : #F16F6F;
		font-weight: 500;
		margin-right: 15px;
	}

	#shedule-btn {
		width: 161.63px;
		border: none;
		display: inline-block;
		padding: 15px 30px;
		border-radius: none;
		background-color : #94D2E6;
		font-weight: 500;
	}

	#right > div:last-child{
		text-align: center;
	}
	
	video {
      width: 100%;
      height: 100%;
      display: block;
      object-fit : cover;
     z-index: 1;
      
   }
   #first{
	display: flex;
   }
   #rule{
		
		background-color: #f8f8f8;
		position: relative;
		z-index: 10000;
	}
	.packer{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}
    .packer-img{
		display: flex;
		flex-direction: column;
		padding: 30px;
		padding-right: 200px;
	}
	.ttee{
		display: flex;
		flex-direction: column;
		justify-content: center;
		padding: 30px;
		padding-left: 200px;
	}
    .packer-img2{
		display: flex;
		flex-direction: column;
		padding: 30px;
		padding-left: 200px;
	}
	.ttee2{
		display: flex;
		flex-direction: column;
		justify-content: center;
		padding: 30px;
		padding-right: 200px;
	}
	
</style>
</head>
<body>
	<main>
	<%@ include file="/WEB-INF/views/common/header_white.jsp" %>
		<%@ include file="/WEB-INF/views/common/nav.jsp" %>
		<div id="first">
			<div id="left">
				<video muted autoplay loop>
					<source src="${root}/static/video/main_video.mp4" type="video/mp4">
				</video>
			</div>
			<div id="right">
				<div id="big-text">백패커</div>
				<div id="btn-area">
				<!-- 임시로 동행게시판으로 만듦. -->
					<button id="packer-btn" onclick="location.href='${root}/accompany/list?page=1'">동행게시판</button>
					<button id="shedule-btn" onclick="location.href='${root}/schedulerpick'">일정짜기</button>
				</div>
				<div>
					프패커란? <br>
					프패커는 동행 및 가이드를 지칭한다
				</div>
			</div>
		</div>

		<div id="rule">

			<div class="packer">
				<div class="ttee">
					<div style="font-size: 2em; font-weight: blod; padding: 10px;">1. 여행기간 선택</div>
					<div style="padding: 10px; padding-left: 15px; color: #8c8c8c;" >
						먼저 여행기간을 선택하세요 . 
						<br> 일정표를 생성하기를 클릭하면
						<br> 여행일정표가 생성됩니다.
					</div>
				</div>
	
				<div class="packer-img">
					<img width=400 height="200" src="${root}/static/img/info/설명1.png" alt="">
					<img width=400 height="200" src="${root}/static/img/info/설명2.png" alt="">
				</div>
			</div>
	
			<div class="packer">
				
				<div class="packer-img2">
					<img width=400 height="400" src="${root}/static/img/info/설명4.png" alt="">
				</div>
				<div class="ttee2">
					<div style="font-size: 2em; font-weight: blod; padding: 10px;">2. 가고싶은 여행지 선택</div>
					<div style="padding: 10px; padding-left: 15px; color: #8c8c8c;" >
						오른쪽에 있는 여행지 장소 리스트에서 
						<br> + 아이콘을 눌러 일정표에 추가합니다.
						<br>  사용자 지정 여행지에서 
						<br>  장소이름 , 시작시간을 설정하여 추가 합니다 
					</div>
				</div>
			</div>
	
			<div class="packer">
				<div class="ttee">
					<div style="font-size: 2em; font-weight: blod; padding: 10px;">3. 여행시간 설정</div>
					<div style="padding: 10px; padding-left: 15px; color: #8c8c8c;" >
						일정표에서 시작시간을 바꿔서 
						<br> 그 날의 일정을 만듭니다.
					</div>
				</div>
	
				<div class="packer-img">
					<img width=400 height="500" src="${root}/static/img/info/설명5.png" alt="">
				</div>
			</div>
	
			<div class="packer">
				
				<div class="packer-img2">
					<img width=600 height="300" src="${root}/static/img/info/설명6.png" alt="">
				</div>
				<div class="ttee2">
					<div style="font-size: 2em; font-weight: blod; padding: 10px;">4. 일정표 저장하기 </div>
					<div style="padding: 10px; padding-left: 15px; color: #8c8c8c;" >
						일정표를 저장하기를 클릭하면 
						<br> 사용자가 만든 일정표가 저장 되고
						<br> 마이페이지에서도 일정을 볼수있게 됩니다.
					</div>
				</div>
			</div>
	
			<div class="packer">
				<div class="ttee">
					<div style="font-size: 2em; font-weight: blod; padding: 10px;">5. 게시판 작성하기 </div>
					<div style="padding: 10px; padding-left: 15px; color: #8c8c8c;" >
						이제 게시글 카테고리를 설정하여 
						<br> 게시글을 작성하고
						<br> 백패커를 구해요!
					</div>
				</div>
	
				<div class="packer-img">
					<img width=400 height="200" src="" alt="">
					<img width=400 height="200" src="" alt="">
				</div>
			</div>
	
		</div>
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</main>
</body>
</html>
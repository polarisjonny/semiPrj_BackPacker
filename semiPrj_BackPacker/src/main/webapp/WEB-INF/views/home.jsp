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
		display: flex;
	}
	


	#left {
		width: 75vw;
		height: 100vh;

		overflow: hidden;
	}
	#right{
		width: 25vw;
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
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header_white.jsp" %>
		<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<main>
	<div id="left">
       <video muted autoplay loop>
          <source src="${root}/static/video/main_video.mp4" type="video/mp4">
       </video>
    </div>
		<div class="box1"></div>
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
		<div class="box2"></div>
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
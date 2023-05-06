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
		height: 1300px; 
	}
	
	#mainReviewImg > img{
		width:100%;
		height:400px;
	}
	
	#notice-title > div{
		text-align:center;
		font-size: 1.8em;
	}
	
	#notice-write{
		display:flex;
		justify-content : space-between;
		margin-bottom:10px;
	}
	
	#notice-writer{
		display:flex;
		margin-left:185px;
	}
	
	#date-hit{
		display:flex;
		margin-right:185px;
	}
	
	.hr{
		margin:auto;
		width:75vw;
	}
	
	#notice-content-area{
		display:flex;
		margin:auto;
		height:700px;
		width:40%;
		text-align:center;
	}
	
	#notice-content{
		font-size:1.2em;
		line-height:48px;
	}
	
	#notice-content > img{
		width:100%;
		height:200px;
	}
	
</style>
</head>
<body>

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
		
	<div id="mainReviewImg">
	<img src="${root}/static/img/travelReview/SingaporeReview.jpg">
	</div>
			
			<br>
			<br>
			
			<div id="notice-title">
				<div>싱가포르 여행은 이틀이면 충분하다</div> <!-- 게시글 제목 -->
			</div>
			
			<br>
			
			<div id="notice-write">
				<div id="notice-writer">
					<div>프사</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;닉네임</div>
				</div>
				
				<div id="date-hit">
					<div>날짜 : 2023.01.09</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;조회수 : 150</div>
				</div>
			</div>
			
			<hr class="hr">
			
			<br>
			
			<div id="notice-content-area">
			
				<div id="notice-content">
						싱가포르는 도시국가다.
						그렇기때문에 이틀이면 
						충분히 여러 관광명소를 
							둘러볼 수 있다.
					처음 간 곳은 마리나배이샌즈 호텔이다.
	<img src="${root}/static/img/travelReview/SingaporeReview.jpg">
							너무 멋있었다.
						야경이 정말 끝내줬다.
					호텔안에 들어가면 밖에 뚫려있는 멋있는 수영장이 있는데
							생각보다 별로였다.
					
						호텔 전체적으로 멀리서 보는게
							더 멋있는거 같다.
				</div>
				
			</div>
		
		</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

</body>
</html>
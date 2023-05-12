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
		height:700px;
		width:100%;
		text-align:center;
	}
	
	#notice-content{
		font-size:1.2em;
		line-height:40px;
		white-space: pre-wrap;
		margin-right:200px;
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
				<div>도쿄 맛집 총정리</div> <!-- 게시글 제목 -->
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
			
			
			<div id="notice-content-area">
			
				<p id="notice-content">
					도쿄 주변 맛집과 먹거리
					야키토리 골목
					리츠 칼튼 도쿄의 히노키자카(ひのきざか)
					닌자 아카사카(ニンジャ アカサカ)
					니다이메 츠지타(二代目つじ田)
					모미노키 하우스(Mominoki House)
					스키야바시지로(すきやばし次郎)
					스시 카라쿠(鮨 からく)
					렌가테이(煉瓦亭)
				</p>
				
			</div>
			
			<c:if test="${loginMember.id == 'ADMIN' }">
				<div id="review-btn">
						<a href="${root}/notice/infomationEdit?no=${vo.no}">수정하기</a>
						<a href="${root}/notice/informationDelete?no=${vo.no}">삭제하기</a>
				</div>
			</c:if>
		
		</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

</body>
</html>
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
		height:300px;
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
		align-items:flex-end;
	}
	
	#date-hit{
		display:flex;
		margin-right:185px;
		align-items:flex-end;
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
	
	#profile-img{
		border-radius : 70%;
	}
	
	#review-btn{
		display : flex;
		align-items: center;
		justify-content:center;
	}
	
	#review-btn > button{
		border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        color:white;
        padding:10px;
        margin:0px 10px 10px;
	}
	
</style>
</head>
<body>

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
		
		<c:if test="${empty vo.changeName }">
			<div id="mainReviewImg">
			<img src="${root}/static/img/travelInformation/travelInfoMain.jpg">
			</div>
		</c:if>
		
		<c:if test="${not empty vo.changeName }">
			<div id="mainReviewImg">
			<img src="${root}/static/img/travelInformation/${vo.changeName}">
			</div>
		</c:if>

			
			<br>
			<br>
			
			<div id="notice-title">
				<div>${vo.title}</div> <!-- 게시글 제목 -->
			</div>
			
			<br>
			
			<div id="notice-write">
				<div id="notice-writer">
					<c:if test="${empty vo.profileImage }">
					<img width="50px" height="50px" id="profile-img" src="${root}/static/img/member/profile/profile_default.jpg">
					</c:if>
					
					<c:if test="${not empty vo.profileImage}">
						<img width="50px" height="50px" id="profile-img" src="${root}/static/img/member/profile/${vo.profileImage}">
					</c:if>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;${vo.writerNick}</div>
				</div>
				
				<div id="date-hit">
					<div>날짜 : ${vo.enrollDate }</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;조회수 : ${vo.hit }</div>
				</div>
			</div>
			
			<hr class="hr">
			
			
			<div id="notice-content-area">
			
				<div id="notice-content">
					${vo.content}
				</div>
				
			</div>
			
			<div id="review-btn">
				<c:if test="${loginMember.id == 'ADMIN' }">
					<button class="edit-btn">수정하기</button>
				</c:if>
					<button onclick="history.back();">목록으로</button>
			</div>
		
		</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

</body>
</html>
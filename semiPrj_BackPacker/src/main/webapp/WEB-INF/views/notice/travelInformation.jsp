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
	
	#mainImg-area{
		position:relative;
	}
	
	#mainImg-area > img{
		width:100%;
		height:400px;
	}

	#mainContent{
		position: absolute;
		display:flex;
		flex-direction:column;
		top: 35%;
		left: 5%;
		color:whitesmoke;
		font-size:2.5em;
	}
	
	#search-area{
		margin-left : 130px;
	}
	
	#search-area select{
		border : 1px solid #B9eeff;
		border-radius:20px;
		background-color:#B9eeff;
		width: 77px;
        height:30px;
	}
	
	#search-area input{
		border-radius: 25px;
        width:250px;
        height:30px;
        text-align: center;
		border : 1px solid lightgray;
	}
	
	#information{
		margin-left:130px;
		font-size:2em;
	}
	
	#information-area1 > img{
		width:60%;
    	height:200px;
        border-radius: 30px;
        margin:auto;
	}
	
	#information-area1{
		display:grid;
		grid-template-columns: repeat(2,1fr);
	}
	
	#information-area2 > img{
		width:60%;
    	height:200px;
        border-radius: 30px;
        margin:auto;
	}
	
	#information-area2{
		display:grid;
		grid-template-columns: 1fr 1fr;
	}
	
	#information-area1 > a , #information-area2 > a{
		margin:auto;
		font-size:1.3em;
	}
	
	 #noticeBtn{
    	
    	display:flex;
    	justify-content: end;
    	margin-right:150px;
    	
    }
    
    #noticeBtn>button{
        border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        width:10%;
        color:white;
    }
    
     #page-area{
    	display:flex;
    	justify-content:center;
    	align-items:center;
    }
    
    #page-area > a{
		margin:15px;
    }

</style>
</head>
<body>

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
	
		<div id="mainImg-area">
			
			<img alt="" src="${root}/static/img/travelInformation/mainImg.jpg">
			
			<div id="mainContent">
				<div>다양한</div>
				<div>여행 정보를</div>
				<div>만나볼 수 있는 곳,</div>
				<div>맛집부터 액티비티까지</div>
			</div>
		
		</div>
		
		<br>
		<br>
		
		<div id="search-area">
			<form action="${root}/notice/travelInformation">
				<select>
					<option value="title">제목</option>
					<option value="writer">작성자</option>
					<option value="category">카테고리</option>
				</select>
				
				<input type="text" placeholder="검색할 단어를 입력하세요.">
			</form>
		</div>
		
		<div id="information">여행정보</div>
		
		
		<div id="information-area1">
			<img alt="" src="${root}/static/img/travelInformation/fireworks.jpg">
			<img alt="" src="${root}/static/img/travelInformation/paris.jpg">
			<a href="#">5.10~5.12 오사카 불꽃놀이 축제</a>
			<a href="#">10.1~10.4 파리 에펠탑 투어</a>
		</div>
		
		<br>
		
		<div id="information-area2">
			<img alt="" src="${root}/static/img/travelInformation/dokyo.jpg">
			<img alt="" src="${root}/static/img/travelInformation/jejudo.jpg">
			<a href="#">도쿄 맛집 총정리</a>
			<a href="#">제주도 액티비티 추천</a>
		</div>
		
		<br>
		
		 <div id="noticeBtn">
	        <button onclick="location.href='${root}/notice/travelInformationWrite'">게시글 작성</button>
        </div>
        
        <div id="page-area">
            	
            	<%-- <c:if test="${pv.currentPage > 1}"> --%>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> < </a>
            	<%-- </c:if> --%>
    
            	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelInformation?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">1</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelInformation?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">2</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelInformation?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">3</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelInformation?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">4</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelInformation?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">5</a>
            		</c:if>
            		
            		<c:if test="${pv.currentPage == i }">	<!-- == 현재 페이지랑 일치하는 경우 -->
            	      	<a>${i}</a>
            		</c:if>
            	</c:forEach>
            	
            	<%-- <c:if test="${pv.currentPage < pv.maxPage}"> --%>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> > </a>
            	<%-- </c:if> --%>
            </div>
		
		
	
	</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

</body>
</html>
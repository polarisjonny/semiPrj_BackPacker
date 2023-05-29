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
		margin-bottom:45px;
	}
	
	#mainImg-area > img{
		width:100vw;
		height:400px;
	}

	#mainImg-text{
		position:absolute;
		top:30%;
		left:60%;
	}
	
	#mainImg-text > #img-text{
		font-size:2.5em;
	}
	
	
	.input-area > input{
        border-radius: 25px;
        width:280px;
        height:30px;
		border : 1px solid lightgray;
		padding-left:45px;
		margin-top:20px;
	}
	
	.input-area{
		position:relative;
	}
	
	.input-area > i{
  		position: absolute;
		top :9px;
		left: 20px;
  	}
  	
	#board-search-area{
		margin-bottom:30px;
  		display:flex;
  		justify-content:center;
  		margin-bottom:40px;
  	}
  	
  	#board-search-area select{
  	
  		border-radius: 20px;
        background-color: #B9eeff;
        border-color:#B9eeff;
        width: 150px;
        height:40px;
        text-align:center;
        font-size:18px;
  	
  	}
  	
  	.board-input-area > input{
        border-radius: 25px;
        width:300px;
        height:40px;
		border : 1px solid lightgray;
		padding-left:45px;
		margin-top:20px;
	}
	
	.board-input-area{
		position:relative;
	}
	
	.board-input-area > i{
  		position: absolute;
		top :9px;
		left: 20px;
		z-index:1;
  	}
  	
  	#main-content{
  		width:50%;
  		margin:auto;
  		display:grid;
		grid-template-columns: 1fr;
  	}
  	
  	#main-inquiry{
  		justify-content:center;
  		align-items:center;
  	}
  	
  	.inquiry-item{
  		border-bottom:1px solid lightgray;
  		margin: 0 20px 40px;
  		font-size: 18px;
  		font-weight:400;
  	}
  	
  	#page-area{
    	display:flex;
    	justify-content:center;
    	align-items:center;
    	margin-bottom:20px;
    }
    #page-area > a{
		margin:15px;
    }
    
    .noticeBtn{
    	width:30%;
    	display:flex;
		align-items:center;
		justify-content:space-evenly;
		margin:auto;
    }
    
    .noticeBtn > span{
    	font-size:16px;
    }
    
    .noticeBtn>button{
        border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        color:white;
        padding:10px;
    }
  	
</style>
</head>
<body>

	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>

		<div id="mainImg-area">
		
			<img alt="" src="${root}/static/img/inquiry/inquiry-main.jpg">
			
			<div id="mainImg-text">
				<div id="img-text">무엇을 도와드릴까요?</div>
				<span class="input-area">
		               	<i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
		               	<input type="text" placeholder="여행지로 검색">
	               </span>
			</div>
		</div>
		
		
		
		
			<div id="board-search-area">
	
				<form action="${root}/notice/">
					<select name="search-type">
		
						<option value="service" selected>서비스문의</option>
						
					</select>
					
						<span class="board-input-area">
			               	<i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
			               	<input type="text" placeholder="문의 제목 검색..">
		               </span>
				</form>
			</div>
	
			<div id="main-content">
				<div id="main-inquiry">
				<c:forEach items="${list}" var="item">
					<div class="inquiry-item">[${item.qnaCategoryName}] ${item.title }</div> 
				</c:forEach>
				</div>
			</div>
				
				 <div id="page-area">
            	
            	<%-- <c:if test="${pv.currentPage > 1}"> --%>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> << </a>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage - 2}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> < </a>
            	<%-- </c:if> --%>
    
            	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelReviewList?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">1</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelReviewList?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">2</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelReviewList?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">3</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelReviewList?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">4</a>
            		</c:if>
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelReviewList?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">5</a>
            		</c:if>
            		
            		<c:if test="${pv.currentPage == i }">	<!-- == 현재 페이지랑 일치하는 경우 -->
            	      	<a>${i}</a>
            		</c:if>
            	</c:forEach>
            	
            	<%-- <c:if test="${pv.currentPage < pv.maxPage}"> --%>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> > </a>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage + 2}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> >> </a>
            	<%-- </c:if> --%>
            	
            </div>
		
            	<div class="noticeBtn">
            	<span>도움이 더 필요하시면</span>
			        <button onclick="location.href='${root}/notice/inquiryWrite'">문의 등록하기</button>
	        	</div>
		



		
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</main>
	
	

</body>
</html>
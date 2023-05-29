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
		width:100vw;
		height: 1100px; 
	}
	
	#mainImg-area{
		position:relative;
	}
	
	#mainImg-area > img{
		width:100vw;
		height:300px;
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
		z-index: 1;
  	}
  	
  	#margin-bottom{
  		margin-bottom:60px;
  	}
  	
  	#mainContent{
  		max-width:1100px;
  		line-height:30px;
		padding: 0 10%;
		margin:auto;
		margin-bottom:20px;
  	}
  	
  	
  	.inquiry-list{
  		display:flex;
  		list-style:none;
  		justify-content:space-between;
  		flex-wrap:wrap;
  		margin:auto;
  	}
  	
  	.inquiry-item{
  		margin: 0 15px 30px;
  	}
  	
  	.inquiry-item > ul > li{
		width: 213px;
  		font-size:15px;
  		list-style:none;
  	}
  	
  	.inquiry-item > ul > li > .list{
  		color : #99ccff;
  	}
  	
  	.item-title{
  		font-size:18px;
  		margin-bottom: 12px;
  		font-weight:700;
		margin-left:30px;
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
				<!-- <span class="input-area">
		               	<i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
		               	<input type="text" placeholder="여행지로 검색">
	            </span> -->
			</div>
		
		</div>
		
		<div id="margin-bottom"></div>
		
		<div id="mainContent">

			<div class="inquiry">
				<ul class="inquiry-list">
				

					<li class="inquiry-item">
						<h3 class="item-title">공지사항</h3>
						<ul>
							<c:set var="count" value="0" /> 

							<c:forEach var="item" items="${list}">
								<c:if test="${item.qnaCategoryNo == '1'}"> 
									<c:if test="${count < 5}"> 
										<li><a href="${root}/notice/inquiryBoardDetail?QnANo=${item.qnaNo}">${item.title}</a></li>
										<c:set var="count" value="${count + 1}" /> 
									</c:if>
								</c:if>
							</c:forEach>
							<li ><a class="list" href="${root}/notice/inquiryBoard?page=1&QnaCategoryNo=1"> 공지사항 더보기> </a></li>
						</ul>
					</li>
					<li class="inquiry-item">
						<h3 class="item-title">FAQ</h3>
						<ul>
							<c:set var="count" value="0" /> 

							<c:forEach var="item" items="${list}">
								<c:if test="${item.qnaCategoryNo == '2'}"> 
									<c:if test="${count < 5}"> 
										<li><a href="${root}/notice/inquiryFAQDetail?QnANo=${item.qnaNo}">${item.title}</a></li>
										<c:set var="count" value="${count + 1}" /> 
									</c:if>
								</c:if>
							</c:forEach>
							<li ><a class="list" href="${root}/notice/inquiryFAQ?page=1&QnaCategoryNo=2"> FAQ 더보기> </a></li>
						</ul>
					</li>
					<li class="inquiry-item">
						<h3 class="item-title">서비스문의</h3>
						<ul>
							<c:set var="count" value="0" /> 

							<c:forEach var="item" items="${list}">
								<c:if test="${item.qnaCategoryNo == '3'}"> 
									<c:if test="${count < 5}"> 
										<li><a href="${root}/notice/inquiryServiceDetail?QnANo=${item.qnaNo}">${item.title}</a></li>
										<c:set var="count" value="${count + 1}" /> 
									</c:if>
								</c:if>
							</c:forEach>
							<li><a class="list" href="${root}/notice/inquiryService?page=1&QnaCategoryNo=3"> 서비스문의 더보기> </a></li>
						</ul>
					</li>
					<li class="inquiry-item">
						<h3 class="item-title">1:1 문의</h3>
						<ul>
							<c:set var="count" value="0" /> 

							<c:forEach var="item" items="${list}">
								<c:if test="${item.qnaCategoryNo == '4'}"> 
									<c:if test="${count < 5}"> 
										<li><a href="${root}/notice/inquiryQnADetail?QnANo=${item.qnaNo}">${item.title}</a></li>
										<c:set var="count" value="${count + 1}" /> 
									</c:if>
								</c:if>
							</c:forEach>
							<li ><a class="list" href="${root}/notice/inquiryQnA?page=1&QnaCategoryNo=4"> 1:1 문의 더보기> </a></li>
						</ul>
					</li>

				</ul>				
			</div>
		
		</div>
		
		<div class="noticeBtn">
            	<!-- <span>도움이 더 필요하시면</span> -->
			        <button onclick="location.href='${root}/notice/inquiryWrite'">문의 등록하기</button>
	    </div>
		
		
		
		
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		
		</main>

		
</body>
</html>
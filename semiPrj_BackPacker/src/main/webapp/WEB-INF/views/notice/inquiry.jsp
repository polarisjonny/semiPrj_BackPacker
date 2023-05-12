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
  		font-size:15px;
  		list-style:none;
  	}
  	
  	.inquiry-item > ul > li > a{
  		color : #99ccff;
  	}
  	
  	.item-title{
  		font-size:18px;
  		margin-bottom: 12px;
  		font-weight:700;
		margin-left:15px;
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
		
		<div id="margin-bottom"></div>
		
		<div id="mainContent">
		
			<div class="inquiry">
				<ul class="inquiry-list">
					<li class="inquiry-item">
						<h3 class="item-title">공지사항</h3>
						<ul>
							<li>[해외]남아프리카 공화국이 현재 역병으로 인해 여행을</ㅣ>
							<li>[국내]제주도 여행선이 태풍으로 인해 유턴중입니...</li>
							<li>상대방을 신뢰할 수 있는 거리 점수를 이용해 신중...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li><a href="${root}/notice/inquiryBoard"> 공지사항 더보기> </a></li>
						</ul>
					</li>
					
					<li class="inquiry-item">
						<h3 class="item-title">FAQ</h3>
						<ul>
							<li>[해외]남아프리카 공화국이 현재 역병으로 인해 여행을</li>
							<li>[국내]제주도 여행선이 태풍으로 인해 유턴중입니...</li>
							<li>상대방을 신뢰할 수 있는 거리 점수를 이용해 신중...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li><a href="${root}/notice/inquiryFAQ"> FAQ 더보기></a></li>
						</ul>
					</li>
					
					<li class="inquiry-item">
						<h3 class="item-title">서비스문의</h3>
						<ul>
							<li>[해외]남아프리카 공화국이 현재 역병으로 인해 여행을</li>
							<li>[국내]제주도 여행선이 태풍으로 인해 유턴중입니...</li>
							<li>상대방을 신뢰할 수 있는 거리 점수를 이용해 신중...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li><a href="${root}/notice/inquiryService"> 서비스문의 더보기></a></li>

						</ul>
					</li>
					
					<li class="inquiry-item">
						<h3 class="item-title">1:1문의</h3>
						<ul>
							<li>[해외]남아프리카 공화국이 현재 역병으로 인해 여행을</li>
							<li>[국내]제주도 여행선이 태풍으로 인해 유턴중입니...</li>
							<li>상대방을 신뢰할 수 있는 거리 점수를 이용해 신중...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li>반드시 매칭이 되서 여행을 가시면 후기를 작성해주세...</li>
							<li><a href="${root}/notice/inquiryQnA"> 1:1문의 더보기></a></li>

						</ul>
					</li>
				</ul>				
			</div>
		
		</div>
		
		<div class="noticeBtn">
            	<span>도움이 더 필요하시면</span>
			        <button onclick="location.href='${root}/notice/inquiryWrite'">문의 등록하기</button>
	    </div>
		
		
		
		
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		
		</main>

		
</body>
</html>
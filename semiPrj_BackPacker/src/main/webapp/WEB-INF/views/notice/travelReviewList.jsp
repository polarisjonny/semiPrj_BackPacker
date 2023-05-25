<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	/* <!-- css --> */
<!-- html, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
	main{
		margin-top: 66px;
		padding: 0px;
		width:100%;
		height: 1100px; 
	}

    #mainImg-area{
       position: relative;
    }
	
	#mainImg-area > #mainImg{
		width:100%;
		height:300px;
		margin:0;
	}

    #mainContent{
        position: absolute;
        top:10%;
        left:65%;
        font-weight: bold;
        font-size: 2em;
        color: rgb(247, 247, 247);
    }
    
    
    #review-search-area{
    	
		display:grid;
		grid-template-columns: 1fr 1fr;
		justify-content:space-around;
		margin:auto;
		width:1000px;
    }
    
    #review-search-area > .noticeBtn{
    	grid-column-end: 5;
    }
    
    .noticeBtn > button{
    	padding:10px;
    }
    
    #review-search-area select{
        border-radius: 20px;
        background-color: #B9eeff;
        border-color:#B9eeff;
        width: 77px;
        height:30px;
        
    }
    
    #review-search-area input{
        border-radius: 25px;
        width:250px;
        height:30px;
		border : 1px solid lightgray;
		padding-left:45px;
    }
    
    #content-area{
        display:grid;
        width:1000px;
        grid-template-columns: 1fr 1fr 1fr;
        margin:auto;
    }
    
    #content-area > #hit{
		grid-column-end: 5;
		margin-top:15px;
    }
    
    #line{color:lightgray;}
    
    
    #review{font-size: 2em}
    
	#reviewList{
		margin:auto;
		width:1000px;
		display:grid;
		grid-template-rows: 1fr 1fr;
        grid-template-columns: 1fr 1fr;
        grid-column-gap:40px;
        grid-row-gap:30px;
        margin:auto;
        justify-content: space-around;
	}    
	
	#reviewList img{
		width:500px;
		height:200px;
		border-radius:30px;
	}
	
	#reviewList a{
		font-size:1.3em;
	}
	
    
    
    .noticeBtn>button{
        border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
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
  
  	.input-area {
  		position:relative;
  	}
  	
  	.input-area > i{
  		position: absolute;
		top :9px;
		left: 20px;
		z-index: 1;
  	}
  	
  		
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>

    
    
    <main>
    

		<div id="mainImg-area">
	        <img id="mainImg" src="${root}/static/img/travelReview/travelReviewMain.jpg" alt="메인 이미지">
	        <div id="mainContent">백팩커들의 솔직한 여행 이야기</div>
		</div>
		
		<br>
		<br>
		
        <div id="review-search-area">
            <form action="${root}/notice/travelReview" method="get">
            	<input type="hidden" name="page" value="1">
                <select name="searchType">
                        <option value="title">제목</option>
                        <option value="writer">닉네임</option>
                </select>
               	
               <span class="input-area">
	               	<i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
	               	<input name="searchValue" type="text" placeholder="검색할 단어를 입력하세요." value="${searchVo.searchValue }">
               </span>
        
            </form>
            
	         <div class="noticeBtn">
		        <button onclick="location.href='${root}/notice/travelReviewWrite'">게시글 작성</button>
	        </div>
        </div>
        
        <div id="content-area">
         

			<div id="review">여행후기</div>
			   
	        <div id="hit">
				<a href="#">조회순</a>  
				 <span id="line">|</span>   
				<a href="#">등록순</a>     
	        </div>
        </div>

      <div id="reviewList">
      	<c:forEach items="${trList}" var="trList">
	        <div id="review-area">
	        	<a href="${root}/notice/travelReviewDetail?infoNo=${trList.infoNo}"><img alt="서브 이미지" src="${root}/static/img/travelReview/${trList.mainImg}"></a>
	           	<div>
	            <a href="${root}/notice/travelReviewDetail?infoNo=${trList.infoNo}">${trList.title}</a> 
	            <!-- infoNo를 get방식으로 전달하여 req.getParameter에 담김 -->
	           	</div>
	        </div>
      	</c:forEach>
      
      </div>  
        
        <br>
        
       
        
        <div id="page-area">
            	
            	<c:if test="${pv.currentPage > 1}">
				  <a style="color:#99ccff" href="${root}/notice/travelReview?page=1&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> << </a>
				  <a style="color:#99ccff" href="${root}/notice/travelReview?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> < </a>
				</c:if>
    
            	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
            		<c:if test="${pv.currentPage != i }"> 	<!-- != 현재 페이지랑 일치하지 않는경우 -->
		            	<a href="${root}/notice/travelReview?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
            		</c:if>
            		
            		<c:if test="${pv.currentPage == i }">	<!-- == 현재 페이지랑 일치하는 경우 -->
            	      	<a style="color:#99ccff">${i}</a>
            		</c:if>
            	</c:forEach>
            	
            	<c:if test="${pv.currentPage < pv.maxPage}">
				  <a style="color:#99ccff" href="${root}/notice/travelReview?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> > </a>
				  <a style="color:#99ccff" href="${root}/notice/travelReview?page=${pv.maxPage}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> >> </a>
				</c:if>
            </div>
   
    
		</main>
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    
	<script>

		const searchValue = '${searchVo.searchValue}';
		const searchType = '${searchVo.searchType}';
		
		if(searchType.length > 1){
			initSearchType();
		}

		function initSearchType(params) {
			const x = document.querySelector('select > option[value="' + searchType + '"]');
			x.selected = true;
		}

		

	</script>
    
    
	

	

</body>
</html>
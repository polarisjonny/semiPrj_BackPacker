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
		height:400px;
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
    	
    	margin-left : 130px;
    	
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
        text-align: center;
		border : 1px solid lightgray;
    }
    
    #content-area{
        margin-left: 130px;
        display:flex;
        align-items:center;
        justify-content:space-between;
    }
    
    #line{color:lightgray;}
    
   	#hit{margin-right:170px;}
    
    #review{font-size: 2em}
    
    #review-area1{
    	display: grid;
        grid-template-columns: 1fr 1fr;
    }
   
    #review-area1 > img{
    	width:60%;
    	height:200px;
        border-radius: 30px;
        margin:auto;
    }
    
    #review-area2{
    	display:grid;
    	grid-template-columns: 1fr 1fr;
        
    }
    
    #review-area2>img{
    	width:60%;
    	height:200px;
        border-radius: 30px;
    	margin:auto;
    }
    
    
    #review-area1 > a , #review-area2 > a{
        font-size: 1.3em;
        margin:auto;
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
	        <img id="mainImg" src="${root}/static/img/travelReview/travelReviewMain.jpg" alt="메인 이미지">
	        <div id="mainContent">백팩커들의 솔직한 여행 이야기</div>
		</div>
		
		<br>
		<br>

        <div id="review-search-area">
            <form action="${root}/notice/travelReviewList">
                <select name="search-type">
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                        <option value="category">카테고리</option>
                </select>
               	
               	<input type="text" placeholder="검색할 단어를 입력하세요.">

            </form>
        </div>
        
        <div id="content-area">

			<div id="review">여행후기</div>
			   
	        
	        <div id="hit">
				<a href="#">조회순</a>  
				 <span id="line">|</span>   
				<a href="#">등록순</a>     
	        </div>
        </div>

        
        <div id="review-area1">
        
        	<img alt="서브 이미지" src="${root}/static/img/travelReview/JejuReview.jpg">
        	<img alt="서브 이미지" src="${root}/static/img/travelReview/osaka.jpg">
            <a href="#">아름다운 제주도 투어 후기</a>
            <a href="#">오사카 유니버셜 스튜디오 여행기</a>

        <br>
        
        </div>
        
        <div id="review-area2">
        
            <img alt="서브 이미지" src="${root}/static/img/travelReview/sanghiReview.jpg">
            <img alt="서브 이미지" src="${root}/static/img/travelReview/SingaporeReview.jpg">
            <a href="#">상하이 건물이 진자 이쁘네요</a>
            <a href="#">상가포르 여행은 언제든 아름다워요</a>
        
        </div>
        
        <br>
        
        <div id="noticeBtn">
	        <button onclick="location.href='${root}/notice/travelReviewWrite'">게시글 작성</button>
        </div>
        
        <div id="page-area">
            	
            	<%-- <c:if test="${pv.currentPage > 1}"> --%>
	            	<a style="color:#99ccff" href="${root}/notice/travelReviewList?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"> < </a>
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
            	<%-- </c:if> --%>
            </div>
   
    
    </main>
    
    
    
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	

	

</body>
</html>
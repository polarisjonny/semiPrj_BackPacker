<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 글 목록 페이지</title>
<style>
        body {
            margin: 0;
            padding: 0;
            width: 100vw;
        }

        #myBoardListTitle {
        	margin-top: 5%;
            text-align: center;
            color: #94d2e6;
            font-weight: bold;
        }

        #board-list-area {
            margin: auto;
            width: 80%;
            height: 90%;
            display: grid;
            grid-template-rows: 1fr 1fr;
            grid-template-columns: 1fr 1fr 1fr 1fr;
        }



        .board-write-img-style {
            width: 90%;
            height: 200px;
        }

        .my-board-list-font-style {
            font-size: 10%;
        }

        #page-list-area {
            margin: auto;
            text-align: center;
            font-size: 20px;
        }


        .page-list-style {
            color: black;
            text-decoration-line: none;
        }

        #previous-deco {
            color: #94d2e6;
        }

        #after-deco {
            color: #94d2e6;
        }
        
        #travel-review-btn {
        	margin-left: 71%;
        	margin-bottom: 3%;
        	height: 40px;
        	width: 250px;
        	border: none;
        	color: white;
        	background-color: #94d2e6;
        	border-radius: 5px;
        	font-weight: bolder;
        }
        
        #page-list-area {
        	margin-top: 3%;
        }
    </style>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
    <h1 id="myBoardListTitle">내가 등록한 글 목록</h1>
    <button type="button" id="travel-review-btn">내가 작성한 여행 후기 글 보기</button>
    <br>
	<br>
    <div id="board-list-area">
    	<c:forEach items="${gvList}" var="vo">
    		<div class="write-style" id="first-write-area" onclick="location.href='${root}/accompany/detail?no='+${vo.guideBoardNo}+'&writerNo='+${vo.writerNo}">
            	<div><img class="board-write-img-style" src="${root}/static/img/accompany/${vo.mainImg}" alt=""></div>
            	<div>${vo.title}.......</div>
             	<div class="my-board-list-font-style">${vo.categoryName}</div>
             	<div class="my-board-list-font-style">작성일 ${vo.enrollDate}</div>
        	</div>
    	</c:forEach>
    </div>

    
    <div id="page-list-area">
    <c:if test="${pv.currentPage > 1}">
	            <a id="previous-deco" class="page-list-style" href="/semi/member/myPage/myBoardList?page=1"><<</a>
	            <a id="previous-deco" class="page-list-style" href="/semi/member/myPage/myBoardList?page=${pv.currentPage-1 }"><</a>
        	</c:if>
            
            <c:forEach begin="${ pv.startPage }" end="${ pv.endPage }" step="1" var="i">
 	           <a class="page-list-style" href="/semi//member/myPage/myBoardList?page=${i}">${i}</a>
            </c:forEach>
            
            <c:if test="${pv.currentPage < pv.maxPage }">
	            <a id="after-deco" class="page-list-style" href="/semi/member/myPage/myBoardList?page=${pv.currentPage+1}">></a>
	            <a id="after-deco" class="page-list-style" href="/semi/member/myPage/myBoardList?page=${pv.maxPage}">>></a>            
            </c:if>
    </div>
   </main>
   
   <script type="text/javascript">
   		const travelReviewBtn = document.querySelector("#travel-review-btn");
   		travelReviewBtn.addEventListener("click", function(){
   			location.href="${root}/member/myPage/myReviewList";
   		});
   </script>
</body>
</html>
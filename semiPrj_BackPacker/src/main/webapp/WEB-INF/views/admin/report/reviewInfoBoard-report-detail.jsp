<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- 폰트어썸 cdn -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>
    <c:set var="root" value = "${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #wrapt{
        width: 800px;
        margin-top: 100px;
        margin-left: auto;
        margin-right: auto;
    }
    #thi{
        text-align: center;
    }
    
    #acbtable {
    width: 800px;
    height : 450px;
    border-collapse: collapse;
    border-spacing: 10px;
    text-align: center;
    font-size: 18px;
    }

    #acbtable th{
    
    border-bottom: 1px solid black;
    }
    #acbtable td{
    padding-top: 10px; 
    padding-bottom: 10px;
    border-bottom: 1px solid black;
    }

    #page-area-acb{
      width : 300px;
      margin: auto;
      display: flex;
      justify-content: space-evenly; 
}
 
  #page-area{
      width : 500px;
      margin: auto;
      display: flex;
      justify-content: space-evenly; 
   }
   #board1{
	display : grid;
	grid-template-columns:1fr 1fr 1fr;
	width : 100%;
}
.cif{
		display : grid;
		grid-template-columns:1fr 1fr 1fr;
		width : 100%;
}
.rcontent{
	height :100px;
	padding-top : 10px;
}
#boardWr{
	height : 600px;
}
</style>
</head>
<body>


   	 <div id="wrapt">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1 id="th1">후기, 정보 게시판 신고 내용</h1>
        <hr>
        <div id="search-area">
                <form action="${root}/admin/reviewInfoBoard/report" method="get">
                    <input type="hidden" value="1" name="page">
                    <select name="searchType" id="opt" >
                    	
                        <option value="writerName">신고자 이름</option>
                        <option value="writerNick" >신고자 닉네임</option>
                        <option value="writerId" >신고자 아이디</option>
                        <option value="content">신고내용</option>
                        
                    </select>
                    <input type="hidden"  value="${selectReviewInfoBoardNo}" name = "selectReviewInfoBoardNo">
                    <input class = "searchValueElem " type = "text" name = "searchValue" value = "${searchVo.searchValue}" placeholder="검색할 내용">
                    <input type="submit"  value="검색">
                    
                </form>

            </div>
        
         <div id="boardWr">
            
	            	<div id="board1">
						<div>
							<h4>신고자 아이디</h4>
						</div>	                        
						<div>
							<h4>신고자 닉네임</h4>
						</div>	               
						<div>
							<h4>신고자 이름</h4>
						</div>	     
	            	</div>
						<hr>          
	                	<c:forEach items="${voList}" var="vo" end="2">
			            	<div class="cif">
		                        <div hidden>${vo.reportNo} </div>   
		                        <div hidden>${vo.memberNo} </div>   
		                        <div hidden>${vo.infoBoardNo} </div>   
		                        <div >${vo.writerId} </div>   
		                        <div >${vo.writerNick} </div>   
		                        <div >${vo.writerName} </div>   
		                       
		                    </div>        
		                    <div>
		                    
		                  
		                        <div class="rcontent"> <strong>내용 : </strong>  ${vo.reportContent}</div>
		                    </div>
			            	<hr>
	                	</c:forEach>
	                
           
            <br><br>
        </div>
           <div id="page-area">
            	<c:if test="${pv.currentPage >1}">
	            	<a class ="btn btn-outline-info" href="${root}/admin/reviewInfoBoard/report?selectReviewInfoBoardNo=${selectReviewInfoBoardNo}&page=${pv.currentPage -1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
            	</c:if>
	           	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
	           		<c:if test="${pv.currentPage != i}">
		            	<a class ="btn btn-outline-info" href="${root}/admin/reviewInfoBoard/report?selectReviewInfoBoardNo=${selectReviewInfoBoardNo}&page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
	           		</c:if>
	           		<c:if test="${pv.currentPage == i}">
		            	<a class ="btn btn-outline-info" >${i}</a>
	           		</c:if>
	           	</c:forEach>
	           	<c:if test="${pv.currentPage != pv.maxPage}">
	            	<a class ="btn btn-outline-info" href="${root}/admin/reviewInfoBoard/report?selectReviewInfoBoardNo=${selectReviewInfoBoardNo}&page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
	           	</c:if>
            </div>
    </div>
</body>

</html>
<script>


	const searchType = '${searchVo.searchType}';
	const searchValue = '${searchVo.searchValue}';
	
	const searchValueSelectTag = document.querySelector("select[name='searchValue']");
	const searchValueInputTag = document.querySelector("input[name='searchValue']");
	
	
	if( searchType.length > 1){
		initSearchType();
	};
	
	function initSearchType(){
	    const x = document.querySelector('select > option[value="' + searchType + '"]');
		x.selected = true;
	
	}
	
	//서치 타입 변경시 함수 실행
	
	




   
</script>
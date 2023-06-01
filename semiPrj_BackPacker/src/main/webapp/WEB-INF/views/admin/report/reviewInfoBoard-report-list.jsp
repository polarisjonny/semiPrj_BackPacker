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
    #board1{
    	height : 600px;
    }
    #acbdiv {
    width: 800px;
    height : 50px;
    text-align: center;
    font-size: 20px;
    display : grid;
  	 grid-template-columns: 1fr 3fr 7fr 4fr 4fr 2fr 2fr;
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
      padding-bottom: 10px;
   }
    
    
    .classdiv{
    	
	    width: 800px;
	    height:70px;
	    text-align: center;
	    font-size: 16px;
	    display : grid;
	  	 grid-template-columns:  1fr 3fr 7fr 4fr 4fr 2fr 2fr;
    }
    button{
    	width : 30px;
    	height : 30px;
    	border : 0px;
    	background-color:white;
    	font-size:12px;
    }
    button:hover{
    	background-color:rgb(214, 248, 246);
    }
    .titles{
    	text-align:start; 
    	padding-left : 10px;
    	
    }
</style>
</head>
<body>


   	 <div id="wrapt">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1 id="th1">후기, 정보 게시판 목록</h1>
        <hr>
        <div id="search-area">
                <form action="${root}/admin/reviewInfoBoard" method="get">
                    <input type="hidden" value="1" name="page">
                    <select name="searchType" id="opt" >
                        <option value="category">게시판 이름</option>
                        <option value="title" >제목</option>
                        <option value="writerNick" >작성자 닉네임</option>
                        <option value="writerId" >작성자 아이디</option>
                        <option value="reportCnt">최소 신고수</option>
                        
                    </select>
                    
                   
                    <select class = "searchValueElem" name="searchValue" >
                        <option value="0">전부</option>
                        <option value="1">1 이상</option>
                        <option value="10">10 이상</option>
                        <option value="20">20 이상</option>
                        <option value="50">50 이상</option>
                        <option value="100">100 이상</option>
                    </select>
                    <input class = "searchValueElem " type = "text" name = "searchValue" value = "${searchVo.searchValue}" placeholder="검색할 내용">
                    <input type="submit" value="검색">
                    
                </form>

            </div>
        <div id="board1">
            
            <div id="acbdiv">
                
                  
                        <div>Go</div>
                        <div>종류</div>
                        <div>제목</div>
                        <div>ID</div>
                        <div>NICK</div>
                        <div>신고수</div>
                        <div>내용</div>
                
               </div>        
               <hr>
                	<c:forEach items="${voList}" var="vo">
	                    <div class="classdiv">
	                        <div><button onclick="goBoard(${vo.infoNo})" value="${vo.infoNo}">${vo.infoNo}</button></div>
	                        <div>${vo.categoryName}</div>
	                        <div class="titles">${vo.title}</div>
	                        <div>${vo.writerId}</div>
	                        <div>${vo.writerNick}</div>
	                        <div>${vo.reportCnt}</div>
	                        <div>
	                        	<form action="${root}/admin/reviewInfoBoard/report" method="get">
                                    <input type="hidden" value="${vo.infoNo}" name="selectReviewInfoBoardNo">
                                    <input type="submit" value="내용">

                                </form>
	                        </div>
	                        </div>
	                        <hr>
                	</c:forEach>
                </div>
            <br><br>
           <div id="page-area">
            	<c:if test="${pv.currentPage >1}">
	            	<a class ="btn btn-outline-info" href="${root}/admin/reviewInfoBoard?page=${pv.currentPage -1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
            	</c:if>
	           	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
	           		<c:if test="${pv.currentPage != i}">
		            	<a class ="btn btn-outline-info" href="${root}/admin/reviewInfoBoard?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
	           		</c:if>
	           		<c:if test="${pv.currentPage == i}">
		            	<a class ="btn btn-outline-info" >${i}</a>
	           		</c:if>
	           	</c:forEach>
	           	<c:if test="${pv.currentPage != pv.maxPage}">
	            	<a class ="btn btn-outline-info" href="${root}/admin/reviewInfoBoard?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
	           	</c:if>
            </div>
        </div>
    </div>
</body>

</body>
</html>
<script>

	function goBoard(infoNo){
	window.location.href = '${root}/notice/travelInformationDetail?infoNo='+infoNo;
	}	
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
	
	const searchTypeTag = document.querySelector('select[name="searchType"]');
	searchTypeTag.addEventListener("change", setSearchValueTag);
	
	function setSearchValueTag(){
	    const searchType =  searchTypeTag.value;
	    //현재 타입이 신고수인지 확인 하고 맞으면 select 로 변경 아니면 원래 input 으로
	    if(searchType == 'reportCnt'){
	        setSearchValueTagSelect()
	    }else{
	        setSearchValueTagInput()
	    }
	}
	
	//검색값 영역을 select로 변경 (타입이 reportCnt일 때)
	function setSearchValueTagSelect(){
	    searchValueSelectTag.classList.add("active");
	    searchValueSelectTag.disabled = false;
	    searchValueInputTag.classList.remove("active");
	    searchValueInputTag.disabled = true;
	
	    searchValueInputTag.value = '';
	
	    
	}
	//검색값 영역을 input 으로 변경 (타입이 reportCnt가 아닐 떄)
	function setSearchValueTagInput(){
	    searchValueInputTag.classList.add("active");
	    searchValueInputTag.disabled = false;
	    searchValueSelectTag.classList.remove("active");
	    searchValueSelectTag.disabled = true;
	}
	//reportCnt 검색 이후 값이 유지되도록
	function initSearchValueSelect(){
	    if(searchType !='reportCnt'){
	        return;
	    }
	    const optionTag = document.querySelector("option[value = '" + searchValue  + "']");
	    optionTag.selected = true;
	}
	setSearchValueTag();//첫화면부터 검색하ㅏ세요 보이게
	initSearchValueSelect();
	
	
	
	
</script>
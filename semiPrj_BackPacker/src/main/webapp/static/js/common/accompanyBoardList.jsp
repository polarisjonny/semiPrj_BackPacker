<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AccompanyFindBoard</title>
<style>
	body {
		overflow-x :hidden;	
	}
    * {
        margin: 0px;
        padding: 0px;
    }
	main {
		width: 100vw;
	}

   
    #content-area {
        display: flex;
    }
    #content-area > div{
        box-sizing: border-box;
    }
    #ca1 {
        width: 15vw;
    }

    #ca2 {
        width: 15vw;
    }

    #c-main {
        width: 70vw;
    }

    #page-area {
        height: 5vh;
    }

    #input-box {
        position: relative;
    }
	#input-box > i {
		position: absolute;
		top :10px;
		left: 5px;
		z-index: 1;
	}
 	#input-box > input {
 		padding-left : 30px;
 	}
    #middle-area {
        display: flex;
        justify-content: space-between;
        align-items: self-end;
    }

    #big-text {
        font-weight: 800;
        font-size: 40px;
    }
    #main-area {
        height: 700px;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
    }
    .content-box {
        margin-right: 25px;
        margin-top: 20px;
        display: grid;
        grid-template-rows: 1fr 3fr 1fr;
        box-shadow: 0px 0px 8px grey;
      
        border-radius: 25px;
    }
   
    .middle-img {
        height: 198px;
        width: 100%;
    }

    .end-content {
        margin-left: 10px;
        margin-right: 10px;
        margin-top: 10px;
    }

  .top-content {
        display: flex;
        align-items: center;
    }
    .profile {
        width: 60px;
        height: 60px;
        border-radius: 70%; 
    }
    .small-text {
        font-size: 13px;
    }
    .right-text {
        margin-left: 10px;
    }
    .left-img {
        vertical-align: center;
        margin-left: 10px;
    }
    #page-area {
        text-align: center;
        margin-top: 50px;
    }
  

    #c-main > div:first-child{
        margin-top: 30px;
        font-size: 14px;
    }
    #search-area {
        margin-bottom: 30px;
    }

    #category-area{
        border-radius: 10px;
        background-color: #D7ECF2;
        border: none;
        font-size: 12px;
        font-weight: 700;
        padding: 5px 0px 5px 10px;
    }
    #input-box input {
        border-radius: 20px;
        border: 1px solid #CBCBCB;
    }
    input::placeholder{
        color: #8c8c8c;
        font-size: 13px;
    }
    input [type=submit]{
        border-radius: 0%;    
    }
    #write-btn {
        padding: 10px 20px 10px 20px;
        background-color: #94D2E6;
        font-size: 20px;
        font-weight: 800;
        color: white;
        border-radius: 10px;
        border: none;
        margin-right: 25px;
    }

    #main-img > img {
        width: 100vw;
        height: 400px;
        object-fit : none;
    }

    #main-img {
        position: relative;
    }
    #info-text {
        font-weight: 800;
        font-size: 40px;
        position: absolute;
        top: 100px;
        left: 50px;
    }
    #page-area > a{
        margin-right: 30px;
    }
    #page-area > a:last-child{
        margin-right: 0px;
    }
     /* 작은 버튼 구해요 합니다버튼*/
  
</style>
</head>
<body>

	<div id="wrap">
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
        <div id="main-img">
            <img src="${root}/static/img/board-main.jpg" alt="">
            <div id="info-text">동행을 구해보세요!</div>
        </div>
        <div id="content-area">
            <div id="ca1"></div>
            <div id="c-main">
                <div><a href="${root}/doFpacker/list?page=1">프패커게시판으로 이동하기</a></div>
                <div id="search-area">
                	<form action="${root}/accompany/list" method="get">
                		<input type="hidden" name="page" value="1">
	                    <select name="searchType" id="category-area">
	                        <option value="title">제목</option>
	                        <option value="writerId">아이디</option>
	                        <option value="writerNick">닉네임</option>
	                    </select>
	                    <span id="input-box">
	                        <i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
	                        <input type="text" name="searchValue" placeholder="검색어를 입력하세요." value="${searchVo.searchValue}">
	                    </span>
	                    <!-- <input type="submit" value="검색"> -->                	
                	</form>
                </div>
                
                <div id="middle-area">
                    <span id="big-text">동행을 찾아보세요</span>
                    <c:if test="${empty loginMember}">
	                    <button id="write-btn" type="button" onclick="f01();">게시글 작성</button>
	                    <script>
	                    	function f01(){
	                    		alert('로그인 먼저 해주세요.');
	                    	}
	                    </script>
                    </c:if>
                    <c:if test="${not empty loginMember}">
	                    <button id="write-btn" type="button" onclick="location.href='${root}/accompany/write'">게시글 작성</button>
                    </c:if>                
                </div>
                
               
                <div id="main-area">
                	<c:forEach items="${gbvoList}" var="vo">
	                	<div class="content-box" onclick="location.href ='${root}/accompany/detail?no='+${vo.guideBoardNo}+'&writerNo='+${vo.writerNo}+'&schedulerNo='+${vo.schedulerNo}">
	                        <div class="top-content">
	                            <div class="left-img">
	              					<c:if test="${not empty vo.profileImage}">
		                                <img class="profile" src="${root}/static/img/member/profile/${vo.profileImage}" alt="">
		                               
	              					</c:if>
	              					<c:if test="${empty vo.profileImage}">
	              						 <img class="profile" src="${root}/static/img/member/profile/profile_default.jpg" alt="">
	              					</c:if>
	                            </div>
	                            <div class="right-text">
	                                <div class="small-text">${vo.id}(${vo.nick})</div>
	                                <div class="small-text">${vo.age}대 ${vo.gender}</div>
	                                <c:if test="${not empty vo.startDate}">
		                                <div class="small-text">${vo.startDate}~${vo.endDate}</div>
	                                </c:if>
	                                <c:if test="${empty vo.startDate}">
		                                <div class="small-text">확정된 일정이 없습니다.</div>	                                
	                                </c:if>
	                            </div>
	                        </div>
	                        <div class="middle-content">
	                            <img class="middle-img" src="${root}/static/img/accompany/${vo.mainImg}" alt="">
	                        </div>
	                        <div class="end-content">${vo.title}</div>
	                    </div>
                	</c:forEach>
                    
                </div>

            </div>
            <div id="ca2"></div>
        </div>
        <div id="page-area">
        	<c:if test="${pv.currentPage >1}">
	            <a href="${root}/accompany/list?page=1&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><<</a>
	            <a href="${root}/accompany/list?page=${pv.currentPage -1 }&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><</a>
        	</c:if>
            
            <c:forEach begin="${ pv.startPage }" end="${ pv.endPage }" step="1" var="i">
 	           <a href="${root}/accompany/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
            </c:forEach>
            
            <c:if test="${pv.currentPage < pv.maxPage }">
	            <a href="${root}/accompany/list?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">></a>
	            <a href="${root}/accompany/list?page=${pv.maxPage}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">>></a>            
            </c:if>
        </div>
        
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</div>
</body>
</html>
<script>
    const searchType = '${searchVo.searchType}';
    const searchValue = '${searchVo.searchValue}';
    function initSearchType(){
		const x = document.querySelector('select > option[value="' + searchType + '"]');
		x.selected = true;
	}
    if(searchType.length > 1){
		initSearchType();
	}
   
</script>
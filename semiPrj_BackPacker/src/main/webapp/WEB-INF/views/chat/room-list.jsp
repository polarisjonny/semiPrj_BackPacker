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
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


</head>
<style>
    #topnothing{
        text-align: center;
        height: 40px;
        padding-top: 10px;
        font-size: 22px;
        background-color: rgb(214, 248, 246);
    }
    .chatlist{
        display: grid;
        grid-template-rows: 1fr 1fr;
        grid-template-columns: 1fr 6fr;
        
        height: 60px;
        
        padding-top: 20px;
    }
    .chatlistImgDiv{
        grid-row: 1/span1;     

    }
    .chatlistImg{
        
        border-radius: 50px;
    }
    .chatlistWrap{
        width: 830px;
        margin: auto;
        height: 700px;
       
    }
    .chatlistMem{
        text-align: end;
        margin-right: 10px;
    }
    #exitChatlist{
        width: 800px;
        height: 50px;
        background-color: rgb(214, 248, 246);
        border: 0px;
        border-radius: 30px;
        text-align: center;
        margin-left: 15px;
    }
    .back{
    	margin-left:450px;
    	border: 1px solid black;
    	text-align: center;
    	width: 70px;
    	
    }
       #page-area{
         width : 500px;
         margin: auto;
         display: flex;
         justify-content: space-evenly; 
   }
    #search{
       display: flex;
      
       
       justify-content: space-between;
   }
    #searchValue{
       background-color: rgba(0, 102, 255, 0.211);
       border-radius: 1px;
   }
   table > tbody > tr{
   		height : 100px;
   }
   .openOldChatByRoomNo{
   
   	width : 80px;
   	height : 30px;
   }
   
</style>
<body>
	<div class="chatlistWrap">

        <div id="topnothing">
            "${loginMember.name}"님의 채팅 리스트
        </div>
        <div id="search">

           
            <div id="search-area">
            <form action="${root}/chat/room/list/open" method="get"">
                <input type="hidden" value="1" name="page">
                    <select name="searchType" id="opt" >
                        <option value="BOARDTITLE" >게시판이름</option>
                        <option value="CHATTINGUSERNICK" >참여자 닉네임</option>
                        
                    </select>
                    
               
                    <input class = "searchValueElem " id="searchValue" type = "text" name = "searchValue" value = "${searchVo.searchValue}" placeholder="검색할 내용">
                    
                    <input type="submit" value="검색">
            </form>
            </div>
        </div>
     	<table>
                <thead>
                	<th hidden>채팅방번호</th>
                    <th>게시판 이름</th>
                    <th>작성자 </th>
                    <th>작성자 </th>
                    <th>신청자 </th>
                    <th>신청자</th>
                    <th>들어가기</th>
                    
                </thead>
                <tbody>
                    <c:forEach items="${ roomList }" var="roomList" >
                    <tr>
                    	<td hidden>${roomList.chattingRoomNo}</td>
                        <td>${roomList.boardTitle}</td>
                        <td><img class="profile" src="${root}/static/img/member/profile/${roomList.chattingUserProfile}" alt="" style="height:100px"></td>
                        <td>${roomList.chattingUserNick}</td>
                        <td><img class="profile" src="${root}/static/img/member/profile/${roomList.chattingUser2Profile}" alt="" style="height:100px"></td>
                        <td>${roomList.chattingUser2Nick}</td>
                        <td><button class="openOldChatByRoomNo"   onclick="openOldChatByRoomNo(event)">들어가기</button></td>
                                           
                    </tr>
                 
                </c:forEach>
                </tbody>

            </table>
  
        
        <hr>
      
  
        <div id="page-area">
               <c:if test="${pv.currentPage > 1}">
                  <a class="btn btn-primary btn-sm" href="${root}/chat/room/list/open?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
               </c:if>
                  <c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
                     <c:if test="${pv.currentPage != i}">
                        <a class="btn btn-primary btn-sm" href="${root}/chat/room/list/open?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
                     </c:if>
                     <c:if test="${pv.currentPage == i}">
                        <a class="btn btn-primary btn-sm">${i}</a>
                     </c:if>
                  </c:forEach>
               <c:if test="${pv.currentPage < pv.maxPage}">
                  <a class="btn btn-primary btn-sm" href="${root}/chat/room/list/open?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
               </c:if>
            </div>
        
    </div>
<script>
	function openOldChatByRoomNo(e){
		 const windowFeatures = `
			    width=600,
			    height=700,
			    left=(screen.width / 2) - 275,
			    top=0,
			    toolbar=no,
			    location=no,
			    status=no,
			    menubar=no,
			    scrollbars=yes,
			    resizable=no`;

        const chattingRoomNo = e.target.parentNode.parentNode.children[0].innerText;
        console.log(chattingRoomNo);
        alert(chattingRoomNo);
 
        const newWindow = window.open('${root}/chat/room/open?chattingRoomNo='+chattingRoomNo, '', windowFeatures);
        	newWindow.addEventListener('load', () => {
        	    const style = document.createElement('style');
        	    style.textContent = `
        	      /* 스크롤바 스타일 설정 */
        	      ::-webkit-scrollbar {
        	        width: 10px;
        	        background-color: white;/* 연한 하늘색 배경색 */
        	      }
        	      ::-webkit-scrollbar-thumb {
        	        background-color:  #E0F2FE; /* 연한 하늘색 스크롤바 색상 */
        	        border-radius: 5px; /* 스크롤바를 둥글게 보이도록 설정 */
        	      }
        	      ::-webkit-scrollbar-thumb:hover {
        	        background-color: #64B5F6; /* 마우스 오버 시 스크롤바 색상 변경 */
        	      }
        	    `;
        	    newWindow.document.head.appendChild(style);
        	  });   
    }



</script>
	
</body>
</html>

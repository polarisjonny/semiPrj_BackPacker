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
        height: 80px;
        padding-top: 30px;
        background-color: rgb(214, 248, 246);
        
    }
    .chatlist{
        display: grid;
        grid-template-rows: 1fr 1fr;
        grid-template-columns: 1fr 6fr;
        
        height: 60px;
        
        padding-top: 20px;
    }
   
    .chatlistImg{
        width : 80px;
        height : 80px;
        border-radius: 70px;
        cursor: pointer;
    }
    .chatlistWrap{
        width: 500px;
        margin: auto;
        height: 600px;
        overflow: visible;
       
    }

 
    #page-area{
         width : 500px;
         margin: auto;
         display: flex;
         justify-content: space-evenly; 
   }
    #search{
       display: grid;
      	margin-right:20px;
       text-align:right;
      
   }
    #searchValue{
       background-color: rgb(214, 248, 246);
       border : 0.2px solid rgb(214, 248, 246);
       padding-left: 5px;
       border-radius: 10px;
   }

   .openOldChatByRoomNo{
   
   	width : 65px;
   	height : 25px;
   	border : 0px;
   	border-radius : 30px;
   	 background-color: rgb(214, 248, 246);
   }
   

   .list-wrap{
   		display : grid;
   		grid-template-columns: 1fr 5fr;
   		height : 100px;
   }
   .list-text{
        display: grid;
        grid-template-rows: 3fr 1fr;
        font-size : 16px;
        height : 100px;
   }
    .list-text2{
        display: grid;
        height: 25px;
        grid-template-columns: 3fr 1fr;
        font-size : 12px;
   }
   .imgdiv{
   		display :grid;
   		grid-template-rows: 4fr 1fr;
   		width:80px;
   		height:100px;
   }
</style>
<body>
        <div id="topnothing">
          
        <div id="search">

            <div id="search-area">
            <form action="${root}/chat/room/list/open" method="get"">
                <input type="hidden" value="1" name="page">
                    <select name="searchType" id="opt" >
                        <option value="BOARDCATEGORYNAME" >타입</option>
                        <option value="BOARDTITLE" >제목</option>
                        <option value="CHATTINGUSERNICK" >닉네임</option>
                        
                    </select>
                    
               
                    <input class = "searchValueElem " id="searchValue" type = "text" name = "searchValue" value = "${searchVo.searchValue}" placeholder="검색할 내용">
                    
                    <input type="submit" value="검색">
            </form>
            </div>
           
        </div>
        </div>
        <hr style="background-color: rgb(214, 248, 246);">
	<div class="chatlistWrap">

    	<div >
          
               
			<c:forEach items="${ roomList }" var="room" end="3" >
				<div  class= "list-wrap">
                   	<div hidden>
                 	   ${room.chattingRoomNo}
                   	</div>
                    	<c:if test="${room.chattingUser2Nick == loginMember.nick}">
	                    	 <div  class = "imgdiv">
    		                   	<img class="chatlistImg" src="${root}/static/img/member/profile/${room.chattingUserProfile}" alt=""  onclick="goProfile(${room.chattingUserNo})">
    		                   	<div id = "rcnt${room.chattingRoomNo}" style="text-align:center; color:red;"></div>
            	        	 </div>
                       	</c:if>
                	   <c:if test="${room.chattingUserNick == loginMember.nick}">
                    	   <div class = "imgdiv">
                       			<img class="chatlistImg" src="${root}/static/img/member/profile/${room.chattingUser2Profile}" alt="" onclick="goProfile(${room.chattingUser2No})">
                       			<div id = "rcnt${room.chattingRoomNo}" style="text-align:center; color:red;"></div>
                       		</div>
						</c:if>     
                        <div class="list-text">

                            <div>[${room.boardCategoryName}]${room.boardTitle}</div>
                            <div class="list-text2">
	                            <c:if test="${room.chattingUserNick == loginMember.nick}">
	                                
	                                <div>${room.chattingUser2Id}(${room.chattingUser2Nick}) </div>
	                            </c:if>
	                            <c:if test="${room.chattingUser2Nick == loginMember.nick}">
	                                
	                                <div>${room.chattingUserId}(${room.chattingUserNick}) </div>
	                            </c:if>
		                        <div class="go-room"><button class="openOldChatByRoomNo"   onclick="openOldChatByRoomNo(${room.chattingRoomNo},${room.chattingUserNo},${room.chattingUser2No})">들어가기</button></div>
                            </div>
                        </div>                  
					</div>
                                           
                    
		     	   
                 	<hr>
               </c:forEach>
               

    	</div>
       
  
        
      
        
    </div>
  
        <div id="page-area">
               <c:if test="${pv.currentPage > 1}">
                  <a class="btn btn-primary btn-sm" href="${root}/chat/room/list/open?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
               </c:if>
                  <c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
                     <c:if test="${pv.currentPage != i}">
                        <a "btn btn-primary btn-sm"  href="${root}/chat/room/list/open?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
                     </c:if>
                     <c:if test="${pv.currentPage == i}">
                        <a "btn btn-primary btn-sm"  >${i}</a>
                     </c:if>
                  </c:forEach>
               <c:if test="${pv.currentPage < pv.maxPage}">
               		
                  <a class="btn btn-primary btn-sm" href="${root}/chat/room/list/open?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
               </c:if>
            </div>
<script>
	function openOldChatByRoomNo(e,o,t){
		 const windowFeatures = `
			    width=370,
			    height=600,
			    left=(screen.width / 2) - 275,
			    top=0,
			    toolbar=no,
			    location=no,
			    status=no,
			    menubar=no,
			    resizable=no`;

        //const chattingRoomNo = e.target.parentNode.parentNode.children[0].innerText;
 
        const newWindow = window.open('${root}/chat/room/open?chattingRoomNo='+e +'&chattingUserNo='+o +'&chattingUser2No='+t +'&type=old', '', windowFeatures);
        window.close();
        
        	
    }

    function goProfile(e){
    	   const width = 650;
    	   const height = 800;
    	   const left = (screen.width / 2) - (width / 2);
    	   const top = 0;
         window.open('${root}/click/profile?selectMemberNo='+e, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
         window.close();

    }

    
    function cntNewMessage(roomNo){
    	$.ajax({
    				url : "${root}/chat/room/list/open",
    				type : "POST",
    				dataType :"json",
    				data : {
    					chattingRoomNo : roomNo.trim(),
    				},
    				success: function(data){
    					let cnt = JSON.parse(data);
    					if(cnt >0){
    						let rcnt =document.querySelector("#rcnt"+roomNo.trim() );				
    						let str = "";
    						str+= '<div style="text-align:center; color:red;">'+cnt+'</div>';
    						rcnt.innerHTML+=str;
    						
    						
    					}else {
    					}
    				},
    				error: ()=>{
    					console.log("에러요 로드 실패...");
    				} ,
    			});
        	
    };
    document.addEventListener("DOMContentLoaded", function (event) {
        // 화면이 켜질 때 모든 div에 대해 cntNewMessage 함수 호출
        let divList = document.querySelectorAll(".list-wrap");
        divList.forEach(function (div) {
            let roomNo = div.querySelector("div[hidden]").textContent.trim();
            cntNewMessage(roomNo);
        });
    });

</script>
	
</body>
</html>

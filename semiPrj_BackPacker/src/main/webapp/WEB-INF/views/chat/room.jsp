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
</head>
<style>
	.chatWrap{
	    background-color: rgb(214, 248, 246);
	    margin: auto;
	    width: 450px;
	  border-radius: 10px;
	  
	}
	.container {
	    font-size: 20px;
	    margin: auto;
	  display: grid;
	  grid-template-columns: 8fr 1fr 1fr;
	  background-color: white;
	  gap: 10px;
	  width: 450px;
	  height: 40px;
	  
	}
	
	.item {
	    text-align: center;
	  
	    padding: 10px;
	}
	.receive-chat-area{
	    
	  	overflow-y: scroll;
	    gap: 10px;
	    height : 500px;
	   
	}
	
	 
	.chat-area {
	display: grid;
	grid-template-columns: 1fr 4fr;
	
	}

	/* 스크롤바 스타일 설정 */
	::-webkit-scrollbar {
		width: 10px;
		background-color: #E0F2FE; /* 연한 하늘색 배경색 */
	}

	::-webkit-scrollbar-thumb {
		background-color: #64B5F6; /* 연한 하늘색 스크롤바 색상 */
		border-radius: 5px; /* 스크롤바를 둥글게 보이도록 설정 */
	}

	::-webkit-scrollbar-thumb:hover {
		background-color: #1976D2; /* 마우스 오버 시 스크롤바 색상 변경 */
	}

	.write-area-btn{
		wirdth : 450px;
	}
	.write-area-btn > textarea{
		width : 450px;
	}
	.write-area-btn > input{
		width : 450px;
	}
	
</style>
<body>
	<div class="chatWrap">
		${loginMember.nick } 님 환영합니다
        <div class="container">
        	<c:if test="${loginMember.nick == vo.chattingUser2Nick}">
        		<div class="item">${vo.chattingUserNick }님과의 대화방</div>
       		</c:if>
             <c:if test="${loginMember.nick != vo.chattingUser2Nick}">
        		<div class="item">${vo.chattingUser2Nick }님과의 대화방</div>
       		</c:if>
            <div class="item">♡</div>
            <div class="item">↕</div>
            
        </div>  
        <br>
			<div class="receive-chat-area">
			
			</div>
           
		<div class= "write-area-btn">
		
						<textarea name="chat" style="resize: none;" placeholder="채팅칸." ></textarea>
						<input type="button" value="채팅작성" onclick="writeChat()">
		</div>
		<br>
		<br>
           
           
       
    </div>
    <script>
   		setInterval(loadChat,100);
 		loadChat();
    	
		//댓글작성
		let chat = null;
		function writeChat(){
			chat = document.querySelector("textarea[name=chat]").value;
			console.log(chat);
			$.ajax({
				url : "${root}/chat/room/send",
				type : "POST",
				data : {
					guideBoardNo : '${vo.guideBoardNo}',
					content : chat ,
					chattingRoomNo :'${vo.chattingRoomNo}',
					chattingUserNo :'${vo.chattingUserNo}',
					chattingUser2No :'${vo.chattingUser2No}',
					matchingCheck :'${vo.matchingCheck}',
					matchingCheck2 :'${vo.matchingCheck2}',
					chattingStatus :'${vo.chattingStatus}',
					chattingUserNick :'${vo.chattingUserNick}',
					chattingUser2Nick :'${vo.chattingUser2Nick}',
				},
				success: (x)=>{
					const chatArea = document.querySelector(".receive-chat-area");
					console.log(x);
					if(x == 'ok'){
						document.querySelector("textarea[name=chat]").value='';
						chatArea.scrollTop = chatArea.scrollHeight;
						loadChat();
						
					}else {
						alert('채팅 작성실패...');
					}
				},
				error: ()=>{
					console.log("채팅작성실패...");
				} ,
			});
		}
	

	
		function loadChat(){
			$.ajax({
				url : '${root}/chat/room/send/list',
				type: "GET" ,
				data : {
					chattingRoomNo :'${vo.chattingRoomNo}',
					
				},
				success : function(data){
					const x  = JSON.parse(data);
					const j = x.length;
					const chatArea = document.querySelector(".receive-chat-area");
					chatArea.innerHTML="";
					let str = "";
					console.log(x);
					for(let i=j-1; i>=0; i--){
						let no = x[i].senderNo;
						console.log(no);
						if(no == ${loginMember.memberNo}){
							str+='<div class="chat-area">';
							str+='<input type="hidden" value="'+x[i].messageNo+'">';
							str+='<div class="profileImage" style="text-align:center;"><img class="profile" src="${root}/static/img/member/profile/'+x[i].senderProfileImage+'" alt="" style="height:70px; border-radius:30px; "><div>'+x[i].senderNick+'</div></div>';
							str+='<div class="content" style="border : 1px solid black; background-color : white; border-radius:10px; margin-right:50px; padding-left : 10px;">'+x[i].content+'</div>';
							str+='<div></div>';
							str+='<div class="enrollDate" style="font-size : 12px; text-align:right; margin-right:50px;">'+x[i].enrollDate;
				
							str+='</div>';
							str+='</div><br><br>';
						}else{
							str+='<div class="chat-area">';
							str+='<input type="hidden" value="'+x[i].messageNo+'">';
							str+='<div class="profileImage" style="text-align:center;"></div>';
							str+='<div class="content" style="border : 1px solid black; background-color : white; border-radius:10px; margin-left:70px; padding-left : 10px;">'+x[i].content+'</div>';
							str+='<div></div>';
							str+='<div class="enrollDate" style="font-size : 12px; text-align:left; margin-left:70px;">'+x[i].enrollDate;
				
							str+='</div>';
							str+='</div><br><br>';
						}
					}
					chatArea.innerHTML+=str;
					
					  // 스크롤을 가장 아래로 조정
		            chatArea.scrollTop = chatArea.scrollHeight;
					  
		            // textarea에 포커스 이동
		            setTimeout(function () {
		                const textarea = document.querySelector('textarea[name=chat]');
		                textarea.focus();
		            }, 0);

					
				},
				error : function(e){
					console.log(e);
				},

			});
		}
		
</script>
</body>
</html>
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
	  height: 700px;
	  border-radius: 10px;
	  overflow: auto;
	  
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
	.receivechatarea{
	    font-size: 14px;
	    margin: auto;
	    display: grid;
	    grid-template-columns: 2fr 7fr 1fr;
	  
	    gap: 10px;
	   
	}
	#receivechattext{
	    border: 1px solid rgba(0, 0, 0, 0.384);
	    border-radius: 10px;
	    background-color: white;
	    padding: 5px;
	    letter-spacing: 0.3px
	
	}
	#receivechatdate{
	    display: flex;
	    align-items: flex-end;
	    justify-content: center;
	    padding-top: 0 ;
	    padding-top: 10px;
	    font-size: 10px;
	}
	.sendchatarea{
	    font-size: 14px;
	    margin: auto;
	    display: grid;
	    grid-template-columns: 2fr 8fr;
	  
	    gap: 10px;
	}
	#sendchatdate{
	    display: flex;
	    align-items: flex-end;
	    justify-content: center;
	    padding-top: 0 ;
	    padding-top: 10px;
	    font-size: 10px;
	}
	
	#sendchattext{
	    padding: 5px;
	    border: 1px solid rgba(0, 0, 0, 0.384);
	    border-radius: 10px;
	    background-color: white;
	    letter-spacing: 0.3px
	
	 
	}
	#chatout{
	    display: flex;
	    align-items: flex-end;
	    justify-content: center;
	
	}
	#chatoutbtn{
	    font-size: 25px;
	    color: crimson;
	    background-color: white;
	    width: 100%;
	    height: 50px;
	    border-radius: 20px;
	    border: 1px solid black;
	    
	}
	#outmsg{
	    text-align: center;
	    
	}
	#outdate{
	    text-align: center;
	    
	}
	#writemsg{
	    padding-left: 10px;
	    width: 320px;
	    height: 30px;
	    border-radius: 10px;
	    border: 1px solid black;
	    box-sizing: border-box;
	}
	#sendmsgbtn{
	    margin-left: 10px;
	    width: 60px;
	    height: 30px;
	    border-radius: 10px;
	    border: 1px solid;
	}
	.chat-area{
		display : grid;
		 grid-template-columns: 1fr 2fr 6fr 1fr;
	}
</style>
<body>
	<div class="chatWrap">
		${vo.chattingUserNick } 환영합니다
        <div class="container">
            <div class="item">${vo.chattingUser2Nick }님과의 대화방</div>
            <div class="item">♡</div>
            <div class="item">↕</div>
            
        </div>  
        <br>
			<div id="receive-chat-area">
			</div>
           
        <div class="chat-area">
						<div id="comment-text">채팅</div>
						<textarea name="chat" style="resize: none;" placeholder="채팅칸."></textarea>
						<input type="button" value="채팅작성" onclick="writeChat()">
		</div>
           
           
       
    </div>
    <script>
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
					console.log(x);
					if(x == 'ok'){
						alert("채팅작성 성공!");
						document.querySelector("textarea[name=chat]").value='';
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
					console.log(x);
					const chatArea = document.querySelector("#receive-chat-area");
					chatArea.innerHTML="";
					let str = "";
					for(let i=0; i<x.length; i++){
						str+='<div class="chat-area">';
						str+='<div class="profileImage"><img class="profile" src="${root}/static/img/member/profile/'+x[i].senderProfileImage+'" alt="" style="height:100px"></div>';
						str+='<input type="hidden" value="'+x[i].messageNo+'">';
						str+='<div class="senderNick">'+x[i].senderNick+'</div>';
						str+='<div class="content">'+x[i].content+'</div>';
						str+='<div class="enrollDate">'+x[i].enrollDate;
			
						str+='</div>';
						str+='</div>';
					}
					chatArea.innerHTML+=str;
				},
				error : function(e){
					console.log(e);
				},

			});
		}
		
</script>
</body>
</html>
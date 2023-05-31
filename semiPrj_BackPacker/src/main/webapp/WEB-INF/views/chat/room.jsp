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
	    background-color: #94d2e6;
	    margin: auto;
	    width: 350px;
	    height : 500px;
	  border-radius: 10px;
	  
	}
	.container {
	    font-size: 20px;
	    margin: auto;
	  display: grid;
	  grid-template-columns: 9fr 1fr ;
	  background-color: white;
	  gap: 10px;
	  width: 350px;
	  height: 40px;
	  
	}
	
	.item {
	    text-align: center;
	  
	    padding: 10px;
	}
	.receive-chat-area{
	    
	  	overflow-y: scroll;
	    gap: 10px;
	    height : 450px;
	   
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
		display : grid;
		grid-template-columns: 5fr 1fr;
		wirdth : 350px;
		height : 55px;
	}

	.content{
		overflow: visible;
		resize: none;
	}
	#chat{
		height : 50px;
	}
	.submit-out-btn{
		display : grid;
		grid-template-columns: 1fr 1fr;
	}
	#out{
		display:none;
	}

	.item{
		height : 30px;
	}
	#toggleButton{
		border : 0px;
		height :40px;
		background-color:white;
	}
	
	#wc {
		border-radius: 10px;
		background-color: white;
		color: #94d2e6;
		border: 3px solid lightgray;
		font-weight: bold;
	}
</style>
<body>
	<div class="chatWrap">
        <div class="container">
        	<c:if test="${loginMember.nick == vo.chattingUser2Nick}">
        		<div class="item">${vo.chattingUserNick }님과의 대화방</div>
       		</c:if>
             <c:if test="${loginMember.nick != vo.chattingUser2Nick}">
        		<div class="item">${vo.chattingUser2Nick }님과의 대화방</div>
       		</c:if>
             <input id="toggleButton" type="button" value="〓" onclick="toggleChat()">
            
        </div>  
        
			<div class="receive-chat-area">
			
			</div>
           
           
		<div class= "write-area-btn" id="ta">
		
						<textarea  name="chat" id="chatInput" style="resize: none;" placeholder="채팅칸." onkeydown="handleEnter(event)" ></textarea>
						<input id ="wc" type="button" value="채팅작성" onclick="writeChat()" disabled>
		</div>
		<div class = "submit-out-btn" id="out">
				<input id="submit" type="button" value="🤝" onclick="submitChat()">
				<input id="" type="button" value="나가기" onclick="outChat()">
					
		</div>
		<br>
		<br>
           
           
       
    </div>




    <script>


    let chatInput = document.querySelector('#chatInput');
    let chatButton = document.querySelector('#wc');
    checkTextarea();
    function checkTextarea() {
        if (chatInput.value.trim() !== '') {
            chatButton.disabled = false;
        } else {
            chatButton.disabled = true;
        }
    }

    chatInput.addEventListener('input', checkTextarea);

    function writeChat() {
        // 채팅 작성 로직 구현
        // ...

        // 채팅 작성 후 textarea 비우기
        chatInput.value = '';

        // 버튼 다시 비활성화
        chatButton.disabled = true;
    }
    
    function handleEnter(event) {
        if (event.keyCode === 13 && !event.shiftKey) {
            event.preventDefault();
            if (chatButton.disabled === false) {
                writeChat();
            }
        }
    }
    
    let toggleButton = document.querySelector('#toggleButton');
    let out = document.querySelector('#out');
    
    let ta = document.querySelector('#ta');
    
    let isChatVisible = true;

    function toggleChat() {
        if (isChatVisible) {
        	out.style.display = 'grid';  // 채팅 요소 보이게 함
        	ta.style.display = 'none';  // 채팅 요소 숨김
            isChatVisible = false;
        } else {
        	
        	out.style.display = 'none';  // 채팅 요소 숨김
          	ta.style.display = 'grid';  // 채팅 요소 보이게 함
            isChatVisible = true;
        }
    }
    
    
    
  
    function outChat(){
		
		
		$.ajax({
			url : "${root}/chat/room/out",
			type : "POST",
			data : {

				chattingRoomNo :'${vo.chattingRoomNo}',
				chattingUserNo :'${vo.chattingUserNo}',
				chattingUser2No :'${vo.chattingUser2No}',
				chattingStatus :'${vo.chattingStatus}',
				content : "상대방이 채팅창을 나갔습니다." ,
				
			},
			success: (x)=>{
				const chatArea = document.querySelector(".receive-chat-area");
				console.log(x);
				if(x == 'ok'){
					document.querySelector("textarea[name=chat]").value='';
					chatArea.scrollTop = chatArea.scrollHeight;
					loadChat();
					 window.close();
				}else {
					alert('아웃실패...');
				}
				
			},
			error: ()=>{
				console.log("아웃실패..");
			} ,
		});
	}
	
    
    
    
    function submitChat(){

		$.ajax({
				url : "${root}/chat/room/submit",
				type : "POST",
				data : {
				
					chattingRoomNo :'${vo.chattingRoomNo}',
					chattingUserNo :'${vo.chattingUserNo}',
					chattingUser2No :'${vo.chattingUser2No}',
					chattingStatus :'${vo.chattingStatus}',
					
				},
				success: (x)=>{
					
					console.log(x);
					if(x == 'ok'){
						submitMessage();
						setTimeout(function() {
							  window.close();
							}, 1000);
						
					}else {
						alert('서브밋 실패...');
					}
				},
				error: ()=>{
				} ,
			});
    	
    	
    }
    
    
    
    
   		let interval;

	   	// 마우스 클릭 상태를 나타내는 변수
	   	let isMouseDown = false;
	   	const chatArea = document.querySelector(".chatWrap");
	   	const receiveChatArea=  document.querySelector(".receive-chat-area");
	   	// 스크롤바 클릭 시 Interval 멈춤
	   	function stopInterval() {
	   	    clearInterval(interval);
	   	}
	
	   	// 스크롤바 해제 시 Interval 다시 시작
	   	function startInterval() {
	   	    interval = setInterval(loadChat, 1000);
	   	}
	   	
	
		 // 마우스 다운 이벤트 리스너 등록
	   	chatArea.addEventListener("mousedown", function() {
	   	    isMouseDown = true;
	   	    stopInterval();
	   	});

	   	// 마우스 업 이벤트 리스너 등록
	   	chatArea.addEventListener("mouseup", function() {
	   	    isMouseDown = false;
	   	    startInterval();
	   	});

	   	// 마우스가 스크롤바 밖으로 벗어날 때 이벤트 리스너 등록
	   	chatArea.addEventListener("mouseleave", function() {
	   	    if (isMouseDown) {
	   	    	startInterval();
	   	    }
	   	});

	   	// 마우스가 스크롤바 안으로 진입할 때 이벤트 리스너 등록
	   	chatArea.addEventListener("mouseenter", function() {
	   	    if (isMouseDown) {
	   	        
	   	     stopInterval();
	   	    }
	   	});
	   	let scrollTimer;
	   	chatArea.addEventListener("wheel", function() {
	   	    stopInterval();

	   	    // 마우스 휠 이벤트가 끝난 후 일정 시간이 지난 뒤에 setInterval 다시 시작
	   	    clearTimeout(scrollTimer);
	   	    scrollTimer = setTimeout(startInterval, 2000); // 500ms 후에 setInterval 다시 시작
	   	});

	   	// 마우스 휠 이벤트 리스너 등록 (크로스 브라우징을 위한 코드)
	   	chatArea.addEventListener("mousewheel", function() {
	   	    stopInterval();

	   	    // 마우스 휠 이벤트가 끝난 후 일정 시간이 지난 뒤에 setInterval 다시 시작
	   	    clearTimeout(scrollTimer);
	   	    scrollTimer = setTimeout(startInterval, 2000); // 500ms 후에 setInterval 다시 시작
	   	});
	   	
	   	
	   	
	   	receiveChatArea.addEventListener("mousedown", function() {
	   	    isMouseDown = true;
	   	    stopInterval();
	   	});

	   	// 마우스 업 이벤트 리스너 등록
	   	receiveChatArea.addEventListener("mouseup", function() {
	   	    isMouseDown = false;
	   	    startInterval();
	   	});

	   	// 마우스가 스크롤바 밖으로 벗어날 때 이벤트 리스너 등록
	   	receiveChatArea.addEventListener("mouseleave", function() {
	   	    if (isMouseDown) {
	   	    	startInterval();
	   	    }
	   	});

	   	// 마우스가 스크롤바 안으로 진입할 때 이벤트 리스너 등록
	   	receiveChatArea.addEventListener("mouseenter", function() {
	   	    if (isMouseDown) {
	   	        
	   	     stopInterval();
	   	    }
	   	});
	   	receiveChatArea.addEventListener("wheel", function() {
	   	    stopInterval();

	   	    // 마우스 휠 이벤트가 끝난 후 일정 시간이 지난 뒤에 setInterval 다시 시작
	   	    clearTimeout(scrollTimer);
	   	    scrollTimer = setTimeout(startInterval, 2000); // 500ms 후에 setInterval 다시 시작
	   	});

	   	// 마우스 휠 이벤트 리스너 등록 (크로스 브라우징을 위한 코드)
	   	receiveChatArea.addEventListener("mousewheel", function() {
	   	    stopInterval();

	   	    // 마우스 휠 이벤트가 끝난 후 일정 시간이 지난 뒤에 setInterval 다시 시작
	   	    clearTimeout(scrollTimer);
	   	    scrollTimer = setTimeout(startInterval, 2000); // 500ms 후에 setInterval 다시 시작
	   	});
	   	// 초기에 Interval 시작
	   	//startInterval();
	





 		loadChat();
    	
		//댓글작성
		function submitMessage(){
			
		
			$.ajax({
				url : "${root}/chat/room/send",
				type : "POST",
				data : {
					guideBoardNo : '${vo.guideBoardNo}',
					content : "매칭확인" ,
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
						document.querySelector("#chatInput").value='';
						chatArea.scrollTop = chatArea.scrollHeight;
						// 버튼 다시 비활성화
				        chatButton.disabled = true;
						loadChat();
						
					}else {
						alert('확정실패...');
					}
				},
				error: ()=>{
					console.log("확정실패..");
				} ,
			});
		}
		
		
		let chat = null;
		function writeChat(){
			chat = document.querySelector("textarea[name=chat]").value;
		
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
					writerNo : '${loginMember.memberNo}',
				},
				success: (x)=>{
					const chatArea = document.querySelector(".receive-chat-area");
					if(x == 'ok'){
						document.querySelector("#chatInput").value='';
						chatArea.scrollTop = chatArea.scrollHeight;
						// 버튼 다시 비활성화
				        chatButton.disabled = true;
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
						console.log(no !=${loginMember.memberNo});
						if(no != ${loginMember.memberNo}){
							str+='<div class="chat-area content">';
							str+='<input type="hidden" value="'+x[i].messageNo+'">';
							str+='<div class="profileImage" style=" cursor: pointer;" onclick="goProfile('+no+')" style="text-align:center;"><img class="profile" src="${root}/static/img/member/profile/'+x[i].senderProfileImage+'" alt="" style="height:60px; border-radius:30px; "></div>';
							str+='<div class = "content" style="width : 250px;"><textarea class="content" style="border : 1px solid black;  background-color : white; border-radius:10px;  margin-right:50px; padding-left : 10px;">'+x[i].content+'</textarea></div>';
							str+='<div>'+x[i].senderNick+'</div>';
							str+='<div class="enrollDate" style="font-size : 12px; text-align:right; margin-right:50px;">'+x[i].enrollDate;
				
							str+='</div>';
							str+='</div><br><br>';
						}else if(no == ${loginMember.memberNo}){
							str+='<div class="chat-area content">';
							str+='<input type="hidden" value="'+x[i].messageNo+'">';
							str+='<div class="profileImage" style="text-align:center;"></div>';
							str+='<div class = "content" style="width : 250px;"><textarea class="content" style="border : 1px solid black;  background-color : white; border-radius:10px; margin-left:70px; padding-left : 10px;">'+x[i].content+'</textarea></div>';
							str+='<div></div>';
							str+='<div class="enrollDate" style="font-size : 12px; text-align:left; margin-left:50px;">'+x[i].enrollDate;
				
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
	
		function goProfile(e){
			   
			   const width = 650;
			   const height = 800;
			   const left = (screen.width / 2) - (width / 2);
			   const top = 0;
			   window.open('${root}/click/profile?selectMemberNo='+e, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
			};
		
</script>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var="root" value = "${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


</head>

<body>
	<h1>채팅방</h1>	
        
        <div id="reply-list-area">
            <table>
                <thead>
                    <tr>
                        <th>chat content</th>
                        <th>writer</th>
                        <th>enrollDate</th>
                    </tr>
                </thead>

                <tbody>

                </tbody>
                <input type="hidden" name="InfoBoardNo" value="${vo.infoNo}">
                <div id="reply-form-area">
                    <input type="text" name="content" placeholder="write chat">
                    <input type="button" value="send message" onclick="sendMessage();">

                </div>
                
            </table>
            
            
        
        </div>
   
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    
<!-- 제이 쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>
<script>

  
	function sendMessage(){

		//댓글 작성
		const message = document.querySelector("input[name=content]").value;
		$.ajax({
			url : "${root}/chat/message/write",
			type : "post",
			data : {
                chattingRoomNo : "${selectCrv.chattingRoomNo}",
                senderNo : "${loginmember.memberNo}",
				InfoBoardNo : "${vo.infoNo}" ,
				content : message,
			},
			success : (x)=>{
				console.log(x);
				if(x == 'ok'){
					alert("댓글작성성공!");
					document.querySelector("input[name=content]").value = "";
					loadMessage();

				}else{
					alert("메시지 전송 실패");
				}
				
			},
			error :(x)=>{
				console.log(x);
			},
		});
	}

//댓글 불러오기
function loadMessage(){
	const replyListArea = document.querySelector("#reply-list-area");
	
	$.ajax({
		url : "${root}/chat/message/list",
		type : "get",
		data : {
			// InfoBoardNo : "${vo.infoNo}",
			senderNo : "${cmv.senderNo}",
			chattingRoomNo : "${selectCrv.chattingRoomNo}",
			content : "${cmv.chattingRoomNo}",
		} ,
		success : (data)=>{
			console.log(data);
			//jason형태로 받아서 화면에 보여주기
			const x = JSON.parse(data);
			console.log(x);

			
			const tbody = document.querySelector("#reply-list-area tbody");
			tbody.innerHTML = "";
			let str = "";
			
			for(let i = 0 ; i < x.length; i++){
				str += "<tr>";
				str += "<td>" + x[i].content + '</td>';
				str += "<td>" + x[i].senderNick + '</td>';
				str += "<td>" + x[i].enrollDate + '</td>';
				str += "</tr>";

				
				

			};
			tbody.innerHTML += str;
			
			
		},
		error : (err)=>{
			console.log(err);
		},
	});

}
setInterval(loadMessage, 1000);

</script>
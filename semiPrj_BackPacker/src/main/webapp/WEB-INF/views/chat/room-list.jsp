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
        width: 450px;
        margin: auto;
        height: 700px;
    }
    .chatlistMem{
        text-align: end;
        margin-right: 10px;
    }
    #exitChatlist{
        width: 450px;
        height: 50px;
        background-color: rgb(214, 248, 246);
        border: 0px;
        border-radius: 30px;
        text-align: center;
        margin-left: auto;
    }
</style>
<body>
	<div class="chatlistWrap">

        <div id="topnothing">
            "${loginMember.name}"님의 채팅 리스트 
        </div>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mP01.JPG" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커]20대 후반 남자입니다. 부산으로 모십..</div>
            <div class="chatlistMem">mingkyu119(김민규)</div>
            
        </div>
        
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp02.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[동행]여행초보끼리 같이 모험떠나실분 구합니...</div>
            <div class="chatlistMem">ehatchu0527(김또치)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mP01.JPG" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커]20대 후반 남자입니다. 부산으로 모십..</div>
            <div class="chatlistMem">mingkyu119(김민규)</div>
            
        </div>
        
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp02.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[동행]여행초보끼리 같이 모험떠나실분 구합니...</div>
            <div class="chatlistMem">ehatchu0527(김또치)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div style="margin: auto;">
            <input type="button" value="나가기" id="exitChatlist">
        </div>
    </div>
</body>
</html>
<script>

  
	/*function sendMessage(){

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
*/
</script>
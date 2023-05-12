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
</style>
<body>
	<div class="chatWrap">
        <div class="container">
            <div class="item">ADMIN(김민규)님과의 대화방</div>
            <div class="item">♡</div>
            <div class="item">↕</div>
            
        </div>  
        <br>
        <div class="receivechatarea">
            <div>
                <div hidden> 셀렉트 멤버 no</div>
                <div>40*40</div>
            </div>
            <div id="receivechattext">
                안녕하세요!!. 예린님! 
            </div>
            <div id="receivechatdate">
                2010.08.09.23:00
            </div>
        </div>
        <br><br>
        <div class="sendchatarea">
            <div id="sendchatdate">
                2010.08.09.23:05
            </div>
            <div id="sendchattext">
                안녕하세요!!. 또치님!! ㅎㅎ 작성한 글 내용은 보시고 연락주신거죠? 코골이nono 면허는 꼭 있어야해요 !!

            </div>
        </div>
        <br><br>
        <div class="receivechatarea">
            <div>
                <div hidden> 셀렉트 멤버 no</div>
                <div>40*40</div>
            </div>
            <div id="receivechattext">
                네네 보고 연락드린거 맞구용. 저는 숙소만 동행하고 싶은데 나머지는 자유시간으로 갖구싶구요.. 혹시 숙소는 어디로 가세요..? 아 저 사진 잘찍어드릴수 있어요. 전 사진찍는거 좋아하는데 예린님은 사진 잘 찍으세요?
            </div>
            <div id="receivechatdate">
                2010.08.09.23:00
            </div>
        </div>
        <br><br>
        <div class="sendchatarea">
            <div id="sendchatdate">
                2010.08.09.23:05
            </div>
            <div id="sendchattext">
                전 사진찍어주는거 좋아해요. 엄청 잘찍지는 못하지만 성심성의껏 원하시는 각도로 찍어드릴게요 ㅎㅎ 

            </div>
        </div>
        <br><br>
        <div id="outmsg">ehatchu0527(김또치)님이 대화방을 나가셨습니다.</div>
        <div id="outdate">2023-04-24 13:00:35 </div>
        <hr>
        <div style="text-align: end; "><button>매칭 확정</button></div>
        <br>
        <div id="chatout"><button class="exit" id="chatoutbtn">채팅방 나가기</button></div>
        <br>
        <div style="margin-left: 10px;">
            <input type="text" placeholder="메시지를 입력하세요" id="writemsg">
            <input type="submit" value="전송" id="sendmsgbtn">
        </div>
    </div>
</body>
</html>
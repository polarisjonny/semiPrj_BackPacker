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
        width: 530px;
        margin: auto;
        height: 700px;
       
    }
    .chatlistMem{
        text-align: end;
        margin-right: 10px;
    }
    #exitChatlist{
        width: 500px;
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
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
        <hr>
        <div class="chatlist">
            <div class="chatlistImgDiv"><img width="50px" height="50px"  class="chatlistImg" src="mp03.jpg" alt="" onclick="imgClick(event)"></div>
            <div class="chatlistTitle">[프패커요청]일본여행시켜주실 프패커 구합니다.</div>
            <div class="chatlistMem">kimstrongminuate(김강분)</div>
            
        </div>
               
        <hr>
        <div style="margin: auto;">
            <input type="button" value="나가기" class="exit">
        </div>
        
    </div>
</body>
</html>
<script>


let exit;
exit= document.querySelector('.exit');
exit.addEventListener('click', function(e) {
	 window.close();
});


</script>
	

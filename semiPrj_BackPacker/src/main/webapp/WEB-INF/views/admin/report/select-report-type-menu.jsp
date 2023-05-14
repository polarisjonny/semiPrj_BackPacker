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
    <c:set var="root" value = "${pageContext.request.contextPath}"></c:set>%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #adbtWrap{
        display: grid;
        grid-template-columns: 1fr 1fr;

        width: 800px;
        height: 500px;
	    margin : auto;
    }

    #guideBoard{
        width: 200px;
        height: 150px;
        background-color: rgba(176, 237, 241, 0.842);
        border-radius: 50px;
        text-align: center;
        font-size: 26px;
        margin-top : 50px;
		margin-left : auto;
		margin-right : auto;
    }

  
    

    #review{
        width: 200px;
        height: 150px;
        background-color: rgba(176, 237, 241, 0.842);
        border-radius: 50px;
        text-align: center;
        font-size: 26px;
         margin-top : 50px;
       	margin-left : auto;
		margin-right : auto;
        
    }
    .intext{
        margin-top: 33px;
    }
</style>
<body>
   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>
   
   <div  style="font-size: 50px; margin-top: 150px; text-align: center;">
    <h1>"${loginMember.name}"관리자님 환영합니다.</h1>
   <hr>
    <br>
    <h2>게시판 신고 목록 조회</h2>
   </div>
   <div id="adbtWrap">
   
        <div id="guideBoard">
            <div class="intext">
                동행, 프페커 <br>게시판
            </div>
            
        </div>
        
        <div id="review">
            <div class="intext">
                후기, 정보 <br>게시판
            </div>
           
        </div>

    </div>
</body>
</html>
<script>
    const guideBoard = document.querySelector('#guideBoard');
    const review = document.querySelector('#review');

    guideBoard.addEventListener("click" , function(e){
        window.location.href = '${root}/admin/guideBoard'
        });
   

    review.addEventListener("click" , function(c){
        window.location.href = '${root}/admin/infoReviewBoard'
        });
</script>
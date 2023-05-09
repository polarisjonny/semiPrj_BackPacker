<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #adbtWrap{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;

        width: 1200px;
        height: 500px;
	    margin : auto;
    }

    #acb{
        width: 300px;
        height: 200px;
        background-color: rgba(176, 237, 241, 0.842);
        border-radius: 50px;
        text-align: center;
        font-size: 30px;

    }

    #fpack{
        width: 300px;
        height: 200px;
        background-color: rgba(176, 237, 241, 0.842);
        border-radius: 50px;
        text-align: center;
        font-size: 30px;
    }

    #review{
        width: 300px;
        height: 200px;
        background-color: rgba(176, 237, 241, 0.842);
        border-radius: 50px;
        text-align: center;
        font-size: 30px;
        
    }
    .intext{
        margin-top: 50px;
    }
</style>
<body>
   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>
   
   <div>
    <h1 style="font-size: 50px; margin-top: 200px;">"${loginMember.name}"님 환영합니다.</h1>
   <hr>
   </div>
   <div id="adbtWrap">
   
        <div id="acb">
            <div class="intext">
                동행게시판 <br>신고목록
            </div>
            
        </div>
        <div id="fpack">
            <div class="intext">
                프패커게시판 <br>신고목록
            </div>
            
        </div>
        <div id="review">
            <div class="intext">
                여행후기 게시판 <br>신고목록
            </div>
           
        </div>

    </div>
</body>
</html>
<script>
    const acb = document.querySelector('#acb');
    const fpack = document.querySelector('#fpack');
    const review = document.querySelector('#review');

    acb.addEventListener("click" , function(e){
        window.location.href = '${root}/admin/acb'
        });
    fpack.addEventListener("click" , function(a){
        window.location.href = '${root}/admin/fpacker'
     });

    review.addEventListener("click" , function(c){
        window.location.href = '${root}/admin/review'
        });
</script>
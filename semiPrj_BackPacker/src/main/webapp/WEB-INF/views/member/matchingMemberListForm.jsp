<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매칭 완료된 회원 목록 페이지</title>
<style>
       body {
       		width: 100vw;
       		padding: 0;
       		margin: 0;
       }

        #matching-title {
        	margin-top: 5%;
            text-align: center;
            color: #94d2e6;
            font-weight: bold;
        }

        #member-list-area {
            margin: auto;
            width: 70%;
            height: 500px;
            margin-right: 10%;
            display: grid;
            grid-template-rows: 1fr 1fr;
            grid-template-columns: 1fr 1fr 1fr 1fr;
        }



        .profile-img-style {
            height: 50%;
        	width: 50%;
        	border-radius: 50%;
        	background-size: cover;
        	background-position: center;
        	background-repeat: no-repeat;
        }


        #page-list-area {
            margin: auto;
            text-align: center;
            font-size: 20px;
        }


        .page-list-style {
            color: black;
            text-decoration-line: none;
        }

        #previous-deco {
            color: #94d2e6;
        }

        #after-deco {
            color: #94d2e6;
        }
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	 <main>
        <h1 id="matching-title">매칭 완료된 회원 목록</h1>
    <br>
    <br>

    <div id="member-list-area">
        <div id="first-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>

        <div id="second-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>
        
        <div id="third-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>

        <div id="fourth-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>

        <div id="fifth-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>

        <div id="sixth-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>

        <div id="seventh-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>

        <div id="eighth-member-area">
             <div class="profile-img-style" style="background-image: url('${root}/static/img/memberExample/lion.jpg');"></div>
            <div>yer5_27</div>
        </div>
    </div>

    <div id="page-list-area">
        <a class="page-list-style" id="previous-deco" href=""><<</a>
        <a class="page-list-style" id="previous-deco" href=""><</a>
        <a class="page-list-style" href="">1</a>
        <a class="page-list-style" href="">2</a>
        <a class="page-list-style" href="">3</a>
        <a class="page-list-style" href="">4</a>
        <a class="page-list-style" href="">5</a>
        <a class="page-list-style" id="after-deco" href="">></a>
        <a class="page-list-style" id="after-deco" href="">>></a>
    </div>
    </main>
    
   
</body>
</html>
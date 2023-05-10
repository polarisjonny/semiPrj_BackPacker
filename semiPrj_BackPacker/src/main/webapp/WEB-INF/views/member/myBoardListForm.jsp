<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 글 목록 페이지</title>
<style>
        body {
            margin: 0;
            padding: 0;
            width: 100vw;
        }

        #myBoardListTitle {
        	margin-top: 5%;
            text-align: center;
            color: #94d2e6;
            font-weight: bold;
        }

        #board-list-area {
            margin: auto;
            width: 80%;
            height: 90%;
            display: grid;
            grid-template-rows: 1fr 1fr;
            grid-template-columns: 1fr 1fr 1fr 1fr;
        }



        .board-write-img-style {
            width: 90%;
            height: 200px;
        }

        .my-board-list-font-style {
            font-size: 10%;
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
    <h1 id="myBoardListTitle">내가 등록한 글 목록</h1>

    <div id="board-list-area">
        <div class="write-style" id="first-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
             <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="second-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
             <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="thrid-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
             <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="fourth-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
            <div class="my-board-list-font-style">동행게시판</div>
            <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="fifth-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
            <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="sixth-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
            <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="seventh-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
            <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>

        <div class="write-style" id="eighth-write-area">
            <div><img class="board-write-img-style" src="/travel.jpg" alt=""></div>
            <div>일본 오사카 같이 갈 동행...</div>
            <div class="my-board-list-font-style">동행게시판</div>
             <div class="my-board-list-font-style">작성일 2017.04.27</div>
        </div>
    </div>

    <br>
    <br>
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
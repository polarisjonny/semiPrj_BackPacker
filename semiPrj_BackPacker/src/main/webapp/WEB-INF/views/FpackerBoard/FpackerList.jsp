<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P_Packer_find_board</title>
<style>
	body {
		overflow-x :hidden;	
	}
    * {
        margin: 0px;
        padding: 0px;
    }
	main {

		width: 100vw;
	}

   
    #content-area {
        display: flex;
    }
    #content-area > div{
        box-sizing: border-box;
    }
    #ca1 {
        width: 10vw;
    }

    #ca2 {
        width: 10vw;
    }

    #c-main {
        width: 80vw;
    }

    #page-area {
        height: 5vh;
    }

    #input-box {
        position: relative;
    }
	#input-box > i {
		position: absolute;
		top :10px;
		left: 5px;
		z-index: 1;
	}
 	#input-box > input {
 		padding-left : 30px;
 	}
    #middle-area {
        display: flex;
        justify-content: space-between;
        align-items: self-end;
    }

    #big-text {
        font-weight: 800;
        font-size: 40px;
    }

   
    #page-area {
        text-align: center;
        margin-top: 30px;
    }
  

    #c-main > div:first-child{
        margin-top: 30px;
        font-size: 14px;
    }
    #search-area {
        margin-bottom: 30px;
    }

    #category-area{
        border-radius: 10px;
        background-color: #D7ECF2;
        border: none;
        font-size: 12px;
        font-weight: 700;
        padding: 5px 0px 5px 10px;
    }
    #input-box input {
        border-radius: 20px;
        border: 1px solid #CBCBCB;
    }
    input::placeholder{
        color: #8c8c8c;
        font-size: 13px;
    }
    input [type=submit]{
        border-radius: 0%;    
    }
    #write-btn {
        padding: 10px 20px 10px 20px;
        background-color: #94D2E6;
        font-size: 20px;
        font-weight: 800;
        color: white;
        border-radius: 10px;
        border: none;
        margin-right: 30px;
    }

    #main-img > img {
        object-fit: none;
        width: 100vw;
        height: 450px;
    }

    #main-img {
        position: relative;
    }
    #info-text {
        font-weight: 800;
        font-size: 40px;
        position: absolute;
        top: 100px;
        left: 50px;
    }
    #page-area > a{
        margin-right: 30px;
    }
    #page-area > a:last-child{
        margin-right: 0px;
    }

    /* main-area content-area 관련 스타일*/
    #main-area {
        display: grid;
        height: 1050px;
        margin-top: 30px;
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
    }

    .content-area > img{
        object-fit: none;
        width: 100%;
        height: 90%;
        border-radius: 30px;
    }

    .content-area {
        margin-bottom: 50px;
        margin-right: 20px;
    }
    .text-small {
        font-size: 16px;
    }
    .content-small-bold {
        font-weight: 600;
    }
    .text-area {
        margin-top: 5px;
    }
</style>
</head>
<body>

	<div id="wrap">
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
        <div id="main-img">
            <img src="${root}/static/img/board-main.jpg" alt="">
            <div id="info-text">
                백패커들이<br>
                당신을<br>
                찾습니다<br>
            </div>
        </div>
        <div id="content-area">
            <div id="ca1"></div>
            <div id="c-main">
                <div>동행구하기 게시판으로 이동하기</div>
                <div id="search-area">
                    <select name="category" id="category-area">
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                    </select>
                    <span id="input-box">
                        <i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
                        <input type="text" placeholder="검색어를 입력하세요.">
                    </span>
                    <!-- <input type="submit" value="검색"> -->
                </div>
                <div id="middle-area">
                    <span id="big-text">프패커합니다</span>
                    <button id="write-btn">게시글 작성</button>
                </div>
                
                
                <div id="main-area">
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        
                        
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>
                    <div class="content-area">
                        <img src="${root}/static/img/middle-img.png" alt="">
                        <div class="text-area">
                            <div class="text-small content-small-bold">취향따라 골라 즐기는 경복궁 한복 체험</div>
                            <div class="text-small">최저가 ￦15,000/인</div>
                        </div>
                    </div>


                    
                </div>

            </div>
            <div id="ca2"></div>
        </div>
        <div id="page-area">
            <a href="#"><<</a>
            <a href="#"><</a>
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">></a>
            <a href="#">>></a>
        </div>
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</div>
</body>
</html>
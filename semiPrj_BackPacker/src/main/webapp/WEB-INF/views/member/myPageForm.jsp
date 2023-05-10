<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<style>
        #my-page-title-area {
            margin: auto;
            width: 50%;
            height: 100px;
            margin-top: 8%;
        }

        #my-page-title {
            color: #94d2e6;
            text-align: center;
            font-size: 40px;
            font-weight: bold;
        }



        #schedule-btn {
            color: white;
            background-color: #94d2e6;
            border: none;
            width: 10%;
            height: 40px;
            float: right;
            border-radius: 5px;
            font-weight: bold;
        }

        #my-page-modify-title {
            margin-left: 25%;
            font-size: 25px;
            font-weight: bold;
        }

        #data-area {
            width: 50%;
            height: 50%;
            margin: auto;
            display: flex;
            flex-direction: row;
        }

        #personal-data-area {
            flex-basis: 50%;
            display: grid;
            grid-template-rows: repeat(6, 1fr);
            grid-template-columns: 1fr 3fr;
            padding-right: 40px;

        }

        #fpacker-area {
            flex-basis: 50%;
            display: grid;
            grid-template-rows: 1fr 4fr 1.5fr;
            grid-template-columns: 1fr 3fr;
        }

        #fpacker-area > div:nth-child(5) {
            grid-column: span 2;
        }

        #id-card-img {
            width: 80%;
            height: 120px;
            float: right;
        }

        #guide-message {
            font-size:10px;
            color:darkgray;
            
        }

        .mypage-button {
            color: white;
            background-color: #94d2e6;
            border: none;
            border-radius: 5px;
            width: 30%;
            height: 30px;
            margin: 4px;
        }

        #my-article-list-title {
            font-size: 24px;
            font-weight: bold;
            margin-left: 25%;
        }

        #my-article-list-btn {
            border:none;
            background-color: white;
            color:#94d2e6;
        }



        .article-image {
            width: 90%;
            height: 70%;
        }

        #my-article-list-area {
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            width: 50%;
            height: 80%;
            margin: auto;
        }

        .article-text-style {
            font-size: 5%;
        }


        #matching-complete-title {
            font-size: 24px;
            font-weight: bold;
            margin-left: 25%;
        }


        #matching-complete-member-list-btn {
            border:none;
            background-color: white;
            color:#94d2e6;
        }

        #matching-complete-member-list-area {
            display: flex;
            flex-direction: row;
            align-content: space-evenly;
            width: 50%;
            height: 50%;
            margin: auto;
            
        }


        .matching-complete-member-image {
            width: 100px;
            height: 100px;
            border-radius: 50%;

        }

        .matching-member-area {
            flex-basis: 25%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }


    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
        <div id="my-page-title-area">
            <div id="my-page-title">MY PAGE</div>
            <button id="schedule-btn">일정 보기</button>
        </div>
        
        
        
        <h2 id="my-page-modify-title">개인정보 수정 및 프패커 등록</h2> 
         <div id="data-area">
           <div id="personal-data-area">
                <div>이름</div>
                <div>김민규</div>
                <div>연령대</div>
                <div>30대</div>
                <div>이메일</div>
                <div>mankyu119@naver.com</div>
                <div>핸드폰번호</div>
                <div>01086319999</div>
                <div>주소</div>
                <div>경기도 성남시 분당구 정자동 KH아파트 101동 1408호</div>
            </div>
    
            <div id="fpacker-area">
                <div>이름</div>
                <div>김땡땡</div>
                <div>신분증 등록</div>
                <div><img id="id-card-img" src="${root}/static/img/memberExample/sample_idcard.png" alt="신분증 사진"></div>
                        
                
                <div id="button-area">
                    <div id="guide-message"><i class="fa-solid fa-circle-info" style="color: #94d2e6;"></i> 이미 프패커로 등록된 유저입니다.</div>
                    <button class="mypage-button">프패커 등록</button>
                    <button class="mypage-button">개인정보 수정</button>
                    <button class="mypage-button">비밀번호 수정</button>
                </div>
                
             </div>
    
             
        
                
        
         </div>
    
    
    
        
            
         
         
        
    
         <br>
         <br>
         <br>
         <br>
         <br>
         <br>
         <br>
    
         <span id="my-article-list-title">내가 등록한 글</span>
         <button id="my-article-list-btn">작성한 모든 글 보기></button>
         <br>
         <br>
         <div id="my-article-list-area">
            <div id="first-article-area">
                <img class="article-image" src="${root}/static/img/memberExample/lion.jpg" alt="여행지 샘플 사진">
                <div id="article-title">오르비스 같이 가실분...</div>
                <div class="article-text-style" id="article-page">동행찾기 게시판</div>
                <div class="article-text-style" id="article-enroll-date">작성일 2017.04.27(목)</div>
                <div class="article-text-style" id="article-views">조회수 1,203회</div>
                
            </div>
    
            <div id="second-article-area">
                <img class="article-image" src="${root}/static/img/memberExample/lion.jpg" alt="여행지 샘플 사진">
                <div id="article-title">오르비스 같이 가실분...</div>
                <div class="article-text-style" id="article-page">동행찾기 게시판</div>
                <div class="article-text-style" id="article-enroll-date">작성일 2017.04.27(목)</div>
                <div class="article-text-style" id="article-views">조회수 1,203회</div>
               
            </div>
    
            <div id="third-article-area">
                <img class="article-image" src="${root}/static/img/memberExample/lion.jpg" alt="여행지 샘플 사진">
                <div id="article-title">오르비스 같이 가실분...</div>
                <div class="article-text-style" id="article-page">동행찾기 게시판</div>
                <div class="article-text-style" id="article-enroll-date">작성일 2017.04.27(목)</div>
                <div class="article-text-style" id="article-views">조회수 1,203회</div>
            </div>
        </div>
    
    
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <span id="matching-complete-title">매칭완료된 회원 목록</span>
        <button id="matching-complete-member-list-btn">회원 목록 더보기></button>
        <br>
        <br>
        <div id="matching-complete-member-list-area">
            
    
            <div class="matching-member-area" id="first-member-area">
                <img class="matching-complete-member-image" src="${root}/static/img/memberExample/lion.jpg" alt="프로필 사진">
                <span>yer5_27</span>
            </div>
    
            <div class="matching-member-area" id="second-member-area">
                <img class="matching-complete-member-image" src="/cat.jpg" alt="프로필 사진">
                <span>yer5_27</span>
            </div>
    
            <div class="matching-member-area" id="third-member-area">
                <img class="matching-complete-member-image" src="/신짱구.png" alt="프로필 사진">
                <span>yer5_27</span>
            </div>
    
    
            <div class="matching-member-area" id="fourth-member-area">
                <img class="matching-complete-member-image" src="/신짱구.png" alt="프로필 사진">
                <span>yer5_27</span>
            </div>
        </div>
            
    </main>
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
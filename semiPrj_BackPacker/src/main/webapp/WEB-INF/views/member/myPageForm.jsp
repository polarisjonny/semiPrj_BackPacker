<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style>
		#main-content {
			margin-top: 10%;
		}

        #my-page-title-area {
            margin: auto;
            width: 50%;
            height: 100px;
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
            width: 15%;
            height: 40px;
            float: right;
            border-radius: 5px;
            font-weight: bold;
        }

        #my-page-modify-title {
            margin-left: 25%;
            font-weight: bold;
            font-size: 25px;
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
        
        #quit-area {
        	margin: auto;
        	text-align: center;
        	margin-left: 37%;
        }
        
        #quit-btn {
        	color: white;
        	background-color: #94d2e6;
        	border-radius: 5px;
        	border: none;
        }


</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main id="main-content">
        <div id="my-page-title-area">
            <div id="my-page-title">MY PAGE</div>
            <button id="schedule-btn">일정 보기</button>
        </div>
        
        
        
        <h2 id="my-page-modify-title">개인정보 수정 및 프패커 등록</h2> 
         <div id="data-area">
           <div id="personal-data-area">
                <div>이름</div>
                <div>${loginMember.name}</div>
                <div>연령대</div>
                <div>${loginMember.age}대</div>
                <div>이메일</div>
                <div>${loginMember.email}</div>
                <div>핸드폰번호</div>
                <div>${loginMember.phoneNumber}</div>
                <div>주소</div>
                <div>${loginMember.address}</div>
            </div>
    
            <div id="fpacker-area">
                
                	<div>이름</div>
                	<div>${loginMember.name}</div>
                	<div>신분증 등록</div>
                	<c:if test="${loginMember.isGuide eq null || loginMember.isGuide eq 'X'}">
                		<div><img id="id-card-img" src="${root}/static/img/member/idCard/noImg.gif" alt="신분증 사진"></div>
                	</c:if>
                	<c:if test="${loginMember.isGuide eq 'O'}">
                		<div><img id="id-card-img" src="${root}/static/img/member/idCard/${loginMember.idCard}" alt="신분증 사진"></div>
                	</c:if>
                	
                <div id="btn-area">
                	<c:if test="${loginMember.isGuide eq 'O'}">
                    	<div id="guide-message"><i class="fa-solid fa-circle-info" style="color: #94d2e6;"></i> 이미 프패커로 등록된 유저입니다.</div>
                </c:if>
                <div id="button-area">
                    <button id="register-btn" class="mypage-button">프패커 등록</button>
                    <button id="edit-info-btn" class="mypage-button">개인정보 수정</button>
                    <button id="password-edit-btn" class="mypage-button">비밀번호 수정</button>
                </div>
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
         <c:if test="${not empty gbList}">
			<div id="my-article-list-area">
            <c:forEach items="${gbList}" var="vo" begin="0" end="3">
            	<div id="first-article-area" onclick="location.href='${root}/accompany/detail?no='+${vo.guideBoardNo}+'&writerNo='+${vo.writerNo}">
                <img class="article-image" src="${root}/static/img/accompany/${vo.mainImg}" alt="여행지 샘플 사진" >
                <div id="article-title">${vo.title}</div>
                <div class="article-text-style" id="article-page">${vo.categoryName}</div>
                <div class="article-text-style" id="article-enroll-date">작성일 ${vo.enrollDate}</div>
                <div class="article-text-style" id="article-views">조회수 ${vo.hit}</div>
                           	</div>
            </c:forEach>
    
            <%-- <div id="second-article-area">
                <img class="article-image" src="${root}/static/img/views/accompany/${gbList[1].mainImg}" alt="여행지 샘플 사진">
                <div id="article-title">${gbList[1].title}</div>
                <div class="article-text-style" id="article-page">${gbList[1].categoryName}</div>
                <div class="article-text-style" id="article-enroll-date">작성일 ${gbList[1].enrollDate}</div>
                <div class="article-text-style" id="article-views">조회수 ${gbList[1].hit}</div>
               
            </div>
    
            <div id="third-article-area">
                <img class="article-image" src="${root}/static/img/views/accompany/${gbList[2].mainImg}" alt="여행지 샘플 사진">
                <div id="article-title">${gbList[2].title}</div>
                <div class="article-text-style" id="article-page">${gbList[2].categoryName}</div>
                <div class="article-text-style" id="article-enroll-date">작성일 ${gbList[2].enrollDate}</div>
                <div class="article-text-style" id="article-views">조회수 ${gbList[2].hit}</div>
            </div> --%>
        </div>         
         </c:if>
    
    
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
        <c:if test="${not empty matchingList}">
        	<div id="matching-complete-member-list-area">
            
    
            <c:forEach items="${matchingList}" var="mVo" begin="0" end="3">
            	<div class="matching-member-area" id="first-member-area" data-member-no="${mVo.memberNo}">
                	<img onclick="openProfile(this)" class="matching-complete-member-image" src="${root}/static/img/member/${mVo.profileImage}" alt="프로필 사진">
                	<span>${mVo.nick}</span>
            	</div>
            </c:forEach>
            <%-- <div class="matching-member-area" id="second-member-area">
                <img class="matching-complete-member-image" src="${root}/static/img/member/${matchingList[1].profileImage}" alt="프로필 사진">
                <span>${matchingList[1].nick}</span>
            </div>
            
    
            <div class="matching-member-area" id="third-member-area">
                <img class="matching-complete-member-image" src="${root}/static/img/member/${matchingList[2].profileImage}" alt="프로필 사진">
                <span>${matchingList[2].nick}</span>
            </div>
    
    
            <div class="matching-member-area" id="fourth-member-area">
                <img class="matching-complete-member-image" src="${root}/static/img/member/${matchingList[3].profileImage}" alt="프로필 사진">
                <span>${matchingList[3].nick}</span>
            </div> --%>
        	</div>
        </c:if>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
    	
    	<div id="quit-area">
    		<button id="quit-btn" data-bs-toggle="modal" data-bs-target=".modal">탈퇴하기</button>
    	</div>
		<div class="modal" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">탈퇴하기</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>탈퇴하시겠습니까?</p>
      </div>
      <div class="modal-footer">
      	<input id="idVal" type="hidden" name="id" value="${loginMember.id}">
        <button id="final-quit-btn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">탈퇴하기</button>
      </div>
    </div>
  </div>
</div>
    
    </main>
    
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    
    
    
    <script>
    	const id = document.querySelector("#idVal").value;
    	
   	 	document.addEventListener("DOMContentLoaded", function() {
    	    var myModal = new bootstrap.Modal(document.querySelector(".modal"));
    	});
   	 	
   	 	const finalQuitBtn = document.querySelector("#final-quit-btn");
   	 	
   	 	finalQuitBtn.addEventListener("click", function(){
   	 		$.ajax({
   	 			url: '${root}/member/quit',
   	 			data : {id: id},
   	 			method : 'post',
   	 			success: function(x) {
   	 				console.log("데이터 송신 성공");
   	 				location.href='${root}/home';
   	 			}, 
   	 			error : function() {
   	 				console.log("데이터 송신 실패...");
   	 			}
   	 			
   	 		});
   	 	});
   	 	
   	 	const registerBtn = document.querySelector("#register-btn");
   	 	registerBtn.addEventListener("click", function(){
   	 		location.href = "${root}/member/join/fpacker";
   	 	});
   	 	
   	 	const editInfoBtn = document.querySelector("#edit-info-btn");
   	 	editInfoBtn.addEventListener("click", function(){
   	 		location.href = "${root}/member/modify/myPage";
   	 	});
   	 	
   	 	const passwordEditBtn = document.querySelector("#password-edit-btn");
   	 	passwordEditBtn.addEventListener("click", function(){
   	 		location.href = "${root}/member/modify/password";
   	 	});
   	 	
   	 	const scheduleBtn = document.querySelector("#schedule-btn");
   	 	scheduleBtn.addEventListener("click", function(){
   	 		location.href = "${root}/member/myPage/schedule/scheduleList";
   	 	});
   	 	
   	 	const myArticleListBtn = document.querySelector("#my-article-list-btn");
   	 	myArticleListBtn.addEventListener("click", function(){
   	 		location.href = "${root}/member/myPage/myBoardList?page=1";
   	 	});
   	 	
   	   const matchingCompleteMemberListBtn = document.querySelector("#matching-complete-member-list-btn");
   	   matchingCompleteMemberListBtn.addEventListener("click", function(){
   		   location.href = "${root}/member/myPage/matchingMemberList?page=1";
   	   });
   	   
   	function openProfile(element) {
        const memberNo = element.parentNode.dataset.memberNo;
        const width = 800;
        const height = 1000;
        const left = (screen.width / 2) - (width / 2);
        const top = 0;
        window.open('${root}/click/profile?selectMemberNo=' + memberNo, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
    }
</script>
    
</body>
</html>
    

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
    	<c:forEach items="${matchingList}" var="vo">
    		 <div id="first-member-area" class="member-area" data-member-no="${vo.memberNo}">
    		 	<div hidden>${vo.memberNo}</div>
             	<div onclick="openProfile(this)" class="profile-img-style" id="imgToProfile2" style="background-image: url('${root}/static/img/member/profile/${vo.profileImage}');"></div>
            	<div>${vo.nick}</div>
        	</div>
    	</c:forEach>
       

        <%-- <div id="second-member-area">
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
        </div> --%>
    </div>

    <div id="page-list-area">
        <c:if test="${pv.currentPage > 1}">
	            <a id="previous-deco" class="page-list-style" href="/semi/member/myPage/matchingMemberList?page=1"><<</a>
	            <a id="previous-deco" class="page-list-style" href="/semi/member/myPage/matchingMemberList?page=${pv.currentPage-1 }"><</a>
        	</c:if>
            
            <c:forEach begin="${ pv.startPage }" end="${ pv.endPage }" step="1" var="i">
 	           <a class="page-list-style" href="/semi//member/myPage/matchingMemberList?page=${i}">${i}</a>
            </c:forEach>
            
            <c:if test="${pv.currentPage < pv.maxPage }">
	            <a id="after-deco" class="page-list-style" href="/semi/member/myPage/matchingMemberList?page=${pv.currentPage+1}">></a>
	            <a id="after-deco" class="page-list-style" href="/semi/member/myPage/matchingMemberList?page=${pv.maxPage}">>></a>            
            </c:if>
    </div>
    </main>
    
 	<script>
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
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

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/header.css">
<meta charset="UTF-8">
<script defer>
$('.dropdown-toggle').dropdown();
</script>
<style>
body{
margin: 0px;
padding: 0px;
}
header{
    margin: 0px;
    padding: 0px;
    width: 100%;
    height: 66px;
    display: flex;
    justify-content: space-between;
    position: fixed;
    top: 0px;
    left: 0px;
    z-index: 9999;

}

.menu {
    height: 66px;
    display: flex;
    align-items: center;
    justify-content : space-evenly;
    width : 24vw;
	background-color: white;

}
.menu > a {
    margin-right: 20px;
    text-decoration: none;
    color: black;
    font-size: 20px;
}

#profile-border {
	border-radius: 70%;
	overflow: hidden;
	margin-right:30px 
}

#profile-btn {
    background-color: white;
    width: 80px;
    border: none;
}
.menu > div:first-child {
    margin-right: 30px;
}
</style>


<header>
    <div class="logo">
           <img width="212px" height="66px" src="${root}/static/img/logo/w_logo.png" alt="">
    </div>
    <div class="menu">
		
		<c:if test="${not empty loginMember}">
			<div>
				<i class="fa-regular fa-comments fa-2xl" style="color: #000000;"></i>
			</div>
		</c:if>
        <a href="#">ABOUT</a>
        <a href="#">여행정보</a>
        <a href="${root}/notice/travelReview">후기</a>
        
       	<c:if test="${empty loginMember }">
	        <a href='${root}/member/login'>로그인</a>
	        <a href='${root}/member/join'>회원가입</a>
       	</c:if>
       	<c:if test="${not empty loginMember}">
			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" id="profile-btn" type="button" data-bs-toggle="dropdown" aria-expanded="false">
				  <img width="60px" height="60px" id="profile-border" src="${root}/static/img/temp_profile.png" alt="">
				</button>
				<ul class="dropdown-menu">
					 <li hidden>${loginMember.memberNo}</li>
					
				  <li><a class="dropdown-item" href="#">Action</a></li>
				  <li><a class="dropdown-item" href="#">Another action</a></li>
				  <li><a class="dropdown-item imgToProfile" href="">내 프로필</a></li>
				</ul>
			  </div>
       	</c:if>
    </div>
</header>

<script >
let imgToProfile = document.querySelector('.imgToProfile');
imgToProfile.addEventListener('click', function(e) {
   const no = e.target.parentNode.parentNode.children[0].innerText; //게시글 작성자 번호
   const width = 800;
   const height = 1000;
   const left = (screen.width / 2) - (width / 2);
   const top = 0;
   window.open('${root}/click/profile?selectMemberNo='+no, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
});


</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/header.css">
<meta charset="UTF-8">
<script defer>
$('.dropdown-toggle').dropdown();
</script>



<header>
    <div class="logo">
           <img width="278px" height="87px" src="${root}/static/img/logo/b_logo.png" alt="">
    </div>
    <div class="menu">
        <a href="#">ABOUT</a>
        <a href="#">여행정보</a>
        <a href="#">후기</a>
        
       	<c:if test="${empty loginMember }">
	        <a href="#">로그인</a>
       	</c:if>
       	<!-- <c:if test="${not empty loginMember}">
			<div class="btn-group">
			  <button type="button" data-bs-toggle="dropdown" class="btn">
			    <img width="70px" height="70px" alt="" src="${root}/static/img/temp_profile.png" id="profile-border">
			  </button>
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="#">Action</a></li>
			    <li><a class="dropdown-item" href="#">Another action</a></li>
			    <li><a class="dropdown-item" href="#">Something else here</a></li>
			    <li><hr class="dropdown-divider"></li>
			    <li><a class="dropdown-item" href="#">Separated link</a></li>
			  </ul>
			</div>
       	</c:if> -->
    </div>
</header>



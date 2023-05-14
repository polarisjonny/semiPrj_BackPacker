<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${root}/static/css/nav.css">
<script defer src="${root}/static/js/common/nav.js"></script>

<nav id="navBody" onclick="toggleSidebar()" >
  <c:if test="${loginMember.id =='ADMIN'}">
       <button class="navBody-menu-btn" style="width: 20px">></button>
       <div class="navBody-sidebar">
           <ul class="navBody-menu-list">
             <li><a href="${root}/admin/member">회원관리</a></li>
             <li><a href="${root}/admin/report">신고관리</a></li>
             <li><a href="${root}/admin/FAQ/write">FAQ수정</a></li>
             <li><a href="${root}/admin/place/list">여행지관리</a></li>
             
             <li><a href="${root}/admin/infoBoard/write">여행정보작성</a></li>
           </ul>
         </div>
  </c:if>
   
</nav>